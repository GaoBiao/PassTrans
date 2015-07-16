package com.goo.passtrans.comment;


/**
 * MD5加密工具类
 * @author he
 *
 */

public class Md5Utils {


	//-----------------------------------------------------------------------------
	//对数据进行加密
	public static String getMd5(String strInfo) {
		String strInfoDigest = "";

		try {
			java.security.MessageDigest messageDigest = java.security.MessageDigest
					.getInstance("MD5");
			messageDigest.update(strInfo.getBytes());
			byte[] bInfoDigest = messageDigest.digest();
			strInfoDigest = byteToHex(bInfoDigest);
		} catch (java.security.NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return strInfoDigest.toLowerCase();
	}

	//-----------------------------------------------------------------------------
	//二进制到十六进制的转换
	public static String byteToHex(byte[] bInfoDigest) {
		String strInfoDigest = "";
		String strTemp = "";
		for (int i = 0; i < bInfoDigest.length; i++) {
			strTemp = (java.lang.Integer.toHexString(bInfoDigest[i] & 0XFF));
			if (strTemp.length() == 1) {
				strInfoDigest = strInfoDigest + "0" + strTemp;
			} else {
				strInfoDigest = strInfoDigest + strTemp;
			}
		}
		return strInfoDigest.toUpperCase();
	}

	//-----------------------------------------------------------------------------
	//十六进制到二进制的转换
	public static byte[] hexToByte(String strInfo) {
		String strHexIndex = "0123456789abcdef0123456789ABCDEF";
		int iInfoLength = strInfo.length() / 2;
		byte bData[] = new byte[iInfoLength];
		int j = 0;
		for (int i = 0; i < iInfoLength; i++) {
			char c = strInfo.charAt(j++);
			int n, b;
			n = strHexIndex.indexOf(c);
			b = (n & 0xf) << 4;
			c = strInfo.charAt(j++);
			n = strHexIndex.indexOf(c);
			b += (n & 0xf);
			bData[i] = (byte) b;
		}
		return bData;
	}

	//-----------------------------------------------------------------------------
}
