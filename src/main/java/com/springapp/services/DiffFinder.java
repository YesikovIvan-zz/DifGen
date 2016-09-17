package com.springapp.services;

public class DiffFinder {
    public static String getDifference(String strFile1, String strFile2) {
        int lastInd = 0;
        StringBuilder strBuilder = new StringBuilder();
        String tempStr;
        String tempStr1 = strFile1;
        while (lastInd <= tempStr1.length()) {
            if (tempStr1.indexOf('\n')+1 > 0) {
                lastInd = tempStr1.indexOf('\n')+1;
                tempStr = tempStr1.substring(0, lastInd-1);
            } else {
                tempStr = tempStr1;
                if (!strFile2.contains(tempStr)) {
                    if (strBuilder.indexOf("File1: ") < 0)
                        strBuilder.append("File1: " + '\n');
                    strBuilder.append(tempStr1 + "\n");
                }
                break;
            }

            if (!strFile2.contains(tempStr)) {
                if (strBuilder.indexOf("File1: ") < 0)
                    strBuilder.append("File1: " + '\n');
                strBuilder.append(tempStr + "\n");
            }
            tempStr1 = tempStr1.substring(lastInd);
            lastInd = tempStr1.length();
        }

        String tempStr2 = strFile2;
        while (lastInd <= tempStr2.length()) {
            if (tempStr2.indexOf('\n')+1 > 0) {
                lastInd = tempStr2.indexOf('\n')+1;
            } else {
                tempStr = tempStr2;
                if (!strFile1.contains(tempStr)) {
                    if (strBuilder.indexOf("File2: ") < 0)
                        strBuilder.append("File2: " + '\n');
                    strBuilder.append(tempStr + "\n");
                }
                break;
            }
            tempStr = tempStr2.substring(0, lastInd-1);
            if (!strFile1.contains(tempStr)) {
                if (strBuilder.indexOf("File2: ") < 0)
                    strBuilder.append("File2: " + '\n');
                strBuilder.append(tempStr + "\n");
            }
            tempStr2 = tempStr2.substring(lastInd);
            lastInd = tempStr2.length();
        }
        return strBuilder.toString();
    }
}
