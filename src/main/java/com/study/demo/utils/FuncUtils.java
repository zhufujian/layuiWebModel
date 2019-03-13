package com.study.demo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 
*
* @Description: 公共处理组件
* @ClassName: FuncUtils 
* @author zhufj
* @date 2019年3月13日 上午9:37:53 
*
 */
public class FuncUtils{

    /***************************************************************************
     * 方法名:getSysDate 功能描述:取系统日期 参数说明: 返回参数:返回系统日期串 编写:yajs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String getSysDate()
    {
        SimpleDateFormat formdate = new SimpleDateFormat("dd");
        java.util.Date curDate = new java.util.Date();
        String ss;
        ss = formdate.format(curDate);
        return ss;
    }
    
    public static boolean isSuccess(String ret_code){
        if(isNull(ret_code)){
            return false;
        }
        if("0000".equals(ret_code) || "000000".equals(ret_code)){
            return true;
        }
        return false;
    }
    
    public static String getSysDateYear()
    {
        SimpleDateFormat formdate = new SimpleDateFormat("yyyy");
        java.util.Date curDate = new java.util.Date();
        String ss;
        ss = formdate.format(curDate);
        return ss;
    }
    public static String getSysDateMonth()
    {
        SimpleDateFormat formdate = new SimpleDateFormat("MM");
        java.util.Date curDate = new java.util.Date();
        String ss;
        ss = formdate.format(curDate);
        return ss;
    }
    public static String getSysDateDay()
    {
        SimpleDateFormat formdate = new SimpleDateFormat("dd");
        java.util.Date curDate = new java.util.Date();
        String ss;
        ss = formdate.format(curDate);
        return ss;
    }

    /***************************************************************************
     * 方法名:getSysTime 功能描述:取系统时间 参数说明: 返回参数:返回系统时间串 编写:yaojs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String getSysTime()
    {
        SimpleDateFormat formdate = new SimpleDateFormat("HH:mm:ss");
        java.util.Date curDate = new java.util.Date();
        String ss;
        ss = formdate.format(curDate);
        return ss;
    }

    /***************************************************************************
     * 方法名:WriteFile 功能描述:写文件 参数说明: 返回参数:返回是否写成功 编写:yaojs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static boolean WriteFile(String fileName, String StrBuf)
            throws IOException
    {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(StrBuf, 0, StrBuf.length());
        bw.newLine();
        bw.close();
        fw.close();
        return true;
    }

    /***************************************************************************
     * 方法名:FormatStringAddBlank 功能描述:给字符串后补空格 参数说明: 返回参数:返回后补的字符串 编写:yaojs
     * 日期:2006.12.13 修改记录:
     * 
     * @throws UnsupportedEncodingException
     **************************************************************************/
    public static String FormatStringAddBlank(String sReturnBuf, int length)
            throws Exception
    {
        StringBuffer tempBuffer = new StringBuffer();
        if (null == sReturnBuf || sReturnBuf.equals("")
                || sReturnBuf.equals("null"))
        {
            for (int i = 0; i < length; i++)
            {
                tempBuffer.append(" ");
            }
            return tempBuffer.toString();
        }
        String s2 = new String(sReturnBuf.getBytes("GB2312"), "ISO8859_1");
        int iLength = s2.length();
        if (length > iLength)
        {
            tempBuffer.append(sReturnBuf);
            for (int j = 0; j < length - iLength; j++)
            {
                tempBuffer.append(" ");
            }
            sReturnBuf = tempBuffer.toString();
        } else if (length < iLength)
        {
            sReturnBuf = absoluteSubstring(sReturnBuf, 0, length);
        }
        return sReturnBuf;
    }

    /***************************************************************************
     * 方法名:getStringLength 功能描述:获取字符的长度,包括汉字的长度 参数说明: 返回参数:返回长度 编写:yaojs
     * 日期:2006.12.13 修改记录:
     * 
     * @throws UnsupportedEncodingException
     **************************************************************************/
    public static int getStringLength(String s1) throws Exception
    {
        if (null == s1 || s1.equals(""))
            return 0;
        String s2 = new String(s1.getBytes("GB2312"), "ISO8859_1");
        return s2.length();
    }

    /***************************************************************************
     * 方法名:FormatStringAddZero 功能描述:给字符串前补0 参数说明: 返回参数:返回前补的字符串 编写:yaojs
     * 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String FormatStringAddZero(String sReturnBuf, int length)
    {
        StringBuffer tempBuffer = new StringBuffer();
        if (null == sReturnBuf || sReturnBuf.equals("")
                || sReturnBuf.equals("null"))
        {
            for (int i = 0; i < length; i++)
            {
                tempBuffer.append("0");
            }
            return tempBuffer.toString();
        }
        int iLength = sReturnBuf.length();
        if (length > iLength)
        {
            for (int j = 0; j < length - iLength; j++)
            {
                sReturnBuf = "0" + sReturnBuf;
            }
        } else if (length < iLength)
        {
            sReturnBuf = absoluteSubstring(sReturnBuf, 0, length);
        }
        return sReturnBuf;
    }

    /***************************************************************************
     * 方法名:MultString 功能描述:将字符串金额变为*100后的金额 参数说明:sMoney：需要变更的字符串， iEr：需要乘的数
     * flag：+代表乘,-代表除 返回参数:返回前补的字符串 编写:yaojs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String MultString(String sMoney, int iEr, String flag)
    {
        if (null == sMoney || sMoney.equals(""))
            return "";
        if (null == flag || flag.equals(""))
            return "";
        sMoney = stringMoveZero(sMoney);
        double iTemp = new Double(sMoney).doubleValue();
        if (flag.equals("+"))
        {
            iTemp = iTemp * iEr;
            int aa = new Double(iTemp).intValue();
            return String.valueOf(aa);
        } else if (flag.equals("-"))
        {
            iTemp = iTemp / iEr;
        }
        return String.valueOf(iTemp);
    }

    /***************************************************************************
     * 方法名:MultStringExt 功能描述:将字符串金额变为*100后的金额 参数说明:sMoney：需要变更的字符串， iEr：需要乘的数
     * flag：+代表乘,-代表除 返回参数:返回前补的字符串 编写:yaojs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String MultStringExt(String sMoney, int iEr, String flag)
    {
        if (null == sMoney || sMoney.equals(""))
            return "";
        if (null == flag || flag.equals(""))
            return "";
        sMoney = stringMoveZero(sMoney);
        double iTemp = new Double(sMoney).doubleValue();
        if (flag.equals("+"))
        {
            iTemp = iTemp * iEr;
            double aa = new Double(iTemp).doubleValue();
            return String.valueOf(aa);
        } else if (flag.equals("-"))
        {
            iTemp = iTemp / iEr;
        }
        return String.valueOf(iTemp);
    }

    /***************************************************************************
     * 方法名:stringMoveZero 功能描述:将字符串金额中负号前的0去掉 参数说明:sMoney：需要变更的字符串， 返回参数:返回的字符串
     * 编写:yaojs 日期:2006.12.13 修改记录:
     **************************************************************************/
    public static String stringMoveZero(String sMoney)
    {
        if (null == sMoney || sMoney.equals(""))
            return "";
        int ilen = sMoney.indexOf("-");
        if (ilen > 0)
            return sMoney.substring(ilen, sMoney.length());
        return sMoney;
    }

    /**
     * 对一个字符串的绝对长度进行拆解(如果遇到汉字字符会把它当作两个字符处理)
     * 
     * @param s
     *            传入的字串
     * @param start
     *            起始绝对位置
     * @param end
     *            终止绝对位置
     * @return 返回的字串 编写:yaojs 日期:2006.12.13
     */
    public static String absoluteSubstring(String s, int start, int end)
    {
        if (s == null || s.equals(""))
        {
            return "";
        }
        try
        {
            String s2 = new String(s.getBytes("GB2312"), "ISO8859_1");
            s2 = s2.substring(start, end);
            return new String(s2.getBytes("ISO8859_1"), "GB2312");
        } catch (Exception e)
        {
            return "";
        }
    }

    /**
     * 对返回的多条记录的字符串进行处理，
     * 
     * @param s
     *            传入的字串
     * @param 单个记录的长度
     * @return 返回字符数组 编写:yaojs 日期:2006.12.13
     * @throws Exception
     */
    public static String[] getAbsoluteSubstringArray(String s, int ilength)
            throws Exception
    {
        if (s == null || s.equals(""))
        {
            return new String[0];
        }
        try
        {
            String s2 = new String(s.getBytes("GB2312"), "ISO8859_1");
            int ilen = s2.length() / ilength;
            if (ilen == 0)
                return new String[0];
            int start = 0;
            int end = ilength;
            String[] returnarray = new String[ilen];
            for (int i = 0; i < ilen; i++)
            {
                String s1 = s2.substring(start, end);
                start = end;
                end = end + ilength;
                returnarray[i] = new String(s1.getBytes("ISO8859_1"), "GB2312");
            }
            return returnarray;
        } catch (Exception e)
        {
            return new String[0];
        }
    }

    /**
     * 对返回的多条记录的字符串进行处理，
     * 
     * @param s
     *            传入的字串
     * @param iLength
     *            短信文本的长度
     * @param 记录数记录本条数据的长度
     * @return 返回字符数组 编写:yaojs 日期:2006.12.13
     * @throws Exception
     */
    public static String[] getAbsoluteSubstringArrayExt(String s, int ilength,
            int extlen) throws Exception
    {
        if (s == null || s.equals(""))
        {
            return new String[0];
        }
        try
        {
            String s2 = new String(s.getBytes("GB2312"), "ISO8859_1");
            int zlen = getStringLength(s);
            int start = 0;
            int end = 0;
            int iRow = new Integer(s2.substring(start, 2)).intValue();
            String[] returnarray = new String[iRow];
            start = start + 2;
            for (int i = 0; i < iRow; i++)
            {
                if (start >= zlen)
                    break;
                int ilen = new Integer(s2.substring(start, start + ilength))
                        .intValue();
                end = start + extlen + ilen;
                String s1 = s2.substring(start, end);
                start = end;
                returnarray[i] = new String(s1.getBytes("ISO8859_1"), "GB2312");
            }
            return returnarray;
        } catch (Exception e)
        {
            return new String[0];
        }
    }

    /**
     * 去除字符串中的所有的空格
     * @param str
     * @return 去除后的字符串
     */
    public static String trimAllBlank(String str)
    {
    	if(null==str)
    		return null;
    	else
    		return str.replace(" ", "");
    }
    public static String trimLRBlank(String str){
    	if(null==str){
    		return null;
    	}
    	return str.trim();
    }
    /**
     * 对一个字符串按间隔分解
     * 
     * @param fieldsru
     *            传入的字串
     * @param tag
     *            间隔符
     * @return 返回的一个数组 编写:yaojs 日期:2006.12.13
     */
    public static String[] spiltStr(String fieldsru, String tag)
    {
        char dot = tag.charAt(0);
        String field;
        field = fieldsru + dot;
        int num = 0;
        int field_len = field.length();
        for (int i = 0; i < field_len; i++)
        {
            if (field.charAt(i) == dot)
            {
                num++;
            }
        }
        String[] returnarray = new String[num];
        int begin = 0;
        int end;
        for (int j = 0; j < num; j++)
        {
            end = field.indexOf(dot, begin);
            returnarray[j] = field.substring(begin, end);
            begin = end + 1;
        }
        return returnarray;
    }

    /**
     * 对一个字符串判断是否为手机号码
     * 
     * @param checkMobile
     *            传入的字串
     * @return ture or false 编写:yaojs 日期:2006.12.13
     */
    public static boolean checkMobile(String fieldsru)
    {
        boolean flag = false;
        if (fieldsru.length() < 11)
            return flag;
        else
        {
            String str = fieldsru.substring(0, 2);
            int num = Integer.parseInt(fieldsru.substring(2, 3));
            if ((str.equals("13") || str.equals("14") || str.equals("15") || str
                    .equals("18"))
                    && num >= 0 && num <= 9 && fieldsru.length() == 11)
                flag = true;
            return flag;
        }
    }

    /**
     * 解密时转换成byte算法时补位
     * 
     * @param strhex
     *            传入的字串符
     * @return byte 编写:yaojs 日期:2006.12.13
     */
    public static byte[] hex2byte(String strhex)
    {
        if (strhex == null)
        {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1)
        {
            return null;
        }

        byte[] b = new byte[l / 2];

        for (int i = 0; i != l / 2; i++)
        {

            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    public static String strchange(String str)
    {
        if (null == str || str.equals("NULL") || str.equals("null"))
        {
            return "";
        } else
            return str;
    }

    public static boolean isNull(String str)
    {
        if (null == str || str.equalsIgnoreCase("NULL") || str.equals(""))
        {
            return true;
        } else
            return false;
    }

    public static String stringToThouMony(String sMoney)
    {
        if (null == sMoney || sMoney.equals(""))
            return "";
        double d = new Double(sMoney).doubleValue();
        DecimalFormat df = new DecimalFormat("##,###,###,###,##0.00");
        return df.format(d);
    }

    public static String FormatMoney(String sMoney)
    {
        if (null == sMoney || sMoney.equals(""))
            return "";
        double d = new Double(sMoney).doubleValue();
        DecimalFormat df = new DecimalFormat("##########0.00");
        return df.format(d);
    }

    /**
     * 对double类型进行造型,提供保留的小数位数,不进行四舍五入
     * @param val
     * @param precision
     * @return
     */
    public static double roundDouble(double val, int precision)
    {
        double factor = Math.pow(10, precision);
        return Math.floor(val * factor) / factor;
    }

    /**
     * 对平台手续费进行格式化
     * 1.首先保留四位小数进行四舍五入
     * 2.取结果,保留三位小数
     * @param fee
     * @param precision
     * @return
     */
    public static String formatFee(double fee, int precision)
    {
        DecimalFormat format = new DecimalFormat("#0.0000");
        return String.valueOf(roundDouble(Double
                .parseDouble(format.format(fee)), precision));
    }

    /**
     * 用户注册生成随机密码
     * @param index
     * @return
     */
    public static String getRandomNumber(int index)
    {
        // 生成随类
        Random random = new Random();
        String sRand = "";
        for (int i = 0; i < index; i++)
        {
            String rand = null;
            if (random.nextInt(6) == i)
            {
                rand = String.valueOf((char) (65 + random.nextInt(26)));
            } else if (random.nextInt(6) == i + 1)
            {
                rand = String.valueOf((char) (97 + random.nextInt(26)));
            } else
            {
                rand = String.valueOf(random.nextInt(10));
            }
            sRand += rand;
        }
        return sRand;
    }

    /**
     * 功能描述：取得隐藏后的手机号码
     * 手机号码隐藏第四位到第七位，中间用****代替
     * 例:13845671234 返回 138****1234
     * @param mobi
     * @return
     */
	public static String hiddenMobile(String mobi) {
		if (!Validator.isCellPhone(mobi)) {
			return mobi;
		}
		return mobi.subSequence(0, 3) + "****"
				+ mobi.subSequence(7, mobi.length());
	}

    /**
     * 功能描述：取得隐藏后的邮箱账号
     * 用户名长度=（1-3）首字母+***@abc.com；
     * 用户名长度>3 用户名最后三位用***代替；
     * 邮箱后缀全文显示。
     * @param email
     * @return
     */
    public static String hiddenEmail(String email)
    {
        if (!Validator.isMailAddress(email))
        {
            return email;
        }
        String[] temp = email.split("@");
        if (temp.length != 2)
        {
            return email;
        } else
        {
            StringBuffer sb = new StringBuffer();
            String pre = temp[0];
            if (pre.length() < 4)
            {
                sb.append(pre.substring(0, 1)).append("***").append("@")
                        .append(temp[1]);
            } else
            {
                CharSequence target = pre.subSequence(pre.length() - 3, pre
                        .length());
                CharSequence replacement = new String("***");
                pre.replace(target, replacement);
                sb.append(pre.replace(target, replacement)).append("@").append(
                        temp[1]);
            }
            return sb.toString();
        }
    }

    /**
     * 里转元方法
     * @param money
     * @return
     */
    public static String formatLTYMoneny(String money)
    {
        if (money == null || money.trim().equals("") || money.equals("null"))
        {
            return "0.00";
        }
        try
        {
            double dmoney = Double.parseDouble(money);
            dmoney /= 1000;
            DecimalFormat format = new DecimalFormat("#0.00#");
            return format.format(dmoney);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    public static String formatLTYMoneny2(String money)
    {
        if (money == null || money.trim().equals("") || money.equals("null"))
        {
            return "0.00";
        }
        try
        {
            double dmoney = -Double.parseDouble(money);
            dmoney /= 1000;
            DecimalFormat format = new DecimalFormat("#0.00#");
            return format.format(dmoney);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * "null"值转换为"0.00"元
     */
    public static String formatNullMoney(String money)
    {
    	if(money.equals("null"))
    	{
    		return "0.00";
    	}
    	return "";
    }
    
    /**
     * 
     */
    public static String subAmt(String amt,String refund_amt){
        
        String amt_new="0";
        String refund_new="0";
        if(!FuncUtils.isNull(amt)){
            amt_new=amt;
        }
        if(!FuncUtils.isNull(refund_amt)){
            refund_new=refund_amt;
        }
        
        try
        {
            double amtN = Double.parseDouble(amt_new);
            double refundN = Double.parseDouble(refund_new);
            double res=amtN-refundN;
            DecimalFormat format = new DecimalFormat("#0");
            return format.format(res);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "0";
        }
        
        
    }
    
    
    /**
     * 里转元方法
     * @param money
     * @return
     */
    public static String formatLTYMoneny2(double dmoney)
    {
        try
        {
            dmoney /= 1000;
            DecimalFormat format = new DecimalFormat("#0.00#");
            return format.format(dmoney);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    
    /**
     * 元转元方法
     * @param money
     * @return
     */
    public static String formatYTYMoneny(double money)
    {
        try
        {

            DecimalFormat format = new DecimalFormat("#0.00#");
            return format.format(money);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 显示卡号后四位
     * @param cardNo
     * @return 卡号后四位
     */
    public static String hiddenCard(String cardNo)
    {
        if (null == cardNo)
        {
            return null;
        } else if (cardNo.length() <= 4)
        {
            return cardNo;
        } else
        {
            return cardNo.substring(cardNo.length() - 4, cardNo.length());
        }
    }
    
    /**
     * 显示卡号前2后5
     */
    public static String hiddenMiddle(String cardNo)
    {
        if(null == cardNo)
        {
            return null;
        }else if(cardNo.length()<=10)
        {
            return cardNo;
        }else
        {
            String head = cardNo.substring(0,2);
            String behand = cardNo.substring(cardNo.length()-5,cardNo.length());
            String hidden = "";
            for(int i=0;i<cardNo.substring(3,cardNo.length()-5).length();i++)
            {
                hidden += "*";
            }
            return head+hidden+behand;
        }
    }
    /**
     * 隐藏银行卡号 格式：62266*******9275
     * 
     * @param bankcard
     * @return
     * @author zhufj
     */
    public static String hiddenBankCard(String bankcard)
    {
        
        if(isNull(bankcard)){
    		return "";
    	}
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bankcard.length(); i++)
        {
            if (i > 5 && i < bankcard.length() - 4)
            {
                sb.append("*");
            } else
            {
                sb.append(bankcard.charAt(i));
            }

        }
        return sb.toString();
    }
    /**
     * 隐藏身份证号的方法
     * @param idNo
     * @return 一前一后不隐藏 如：5*****************5
     */
    public static String hiddenCertifiID(String idNo)
    {
    	 if (isNull(idNo))
         {
             return "";
         }
        String head = idNo.substring(0, 1);
        String end = idNo.substring(idNo.length() - 1);
        String sbf = head;
        for (int i = 0; i < idNo.length() - 2; i++)
        {
            sbf += "*";
        }
        sbf += end;
        return sbf;
    }

    /**
     * 功能描述：序列号处理-->微软格式 序列号头字母大于等于8的，添加00
     * @param numer
     * @return
     */
    public static String buildCertSerialnumber(String numer)
    {
        if (isNull(numer))
        {
            return numer;
        }
        String first = numer.substring(0, 1);
        if (Integer.valueOf(first, 16) >= 8)
        {
            return "00" + numer;
        }
        return numer;
    }

    /**
     * 功能描述：日期改变方法 
     * @param date
     * @param day 为改变日期的天数
     * @return
     */
    public static String changeDay(String date, int day)
    {
        if (date != null && date.trim().length() > 0)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date newDate = sdf.parse(date);
                Calendar cal = Calendar.getInstance();
                cal.setTime(newDate);
                cal.add(Calendar.DATE, day);
                Date nextDate = cal.getTime();
                String next_dateStr = new SimpleDateFormat("yyyy-MM-dd")
                        .format(nextDate);
                return next_dateStr;
            } catch (Exception e)
            {
                return date;
            }

        }
        return date;
    }

    /**
     * 
     * 功能描述：元转里方法
     * @param yuan
     * @return
     */
    public static String formatYTLMoneny(String yuan)
    {
        double dYuan = Double.parseDouble(yuan);
        double dLi = dYuan * 1000;
        DecimalFormat format = new DecimalFormat("#");
        return format.format(dLi);
    }
    
    /**
     * 
     * 功能描述：元转里方法
     * @param yuan
     * @return
     */
    public static double formatYTLMoneny2(String yuan)
    {
        double dYuan = Double.parseDouble(yuan);
        double dLi = dYuan * 1000;
        return dLi;
    }
    
    public static String formatMoney(String yuan)
    {
        if(isNull(yuan)){
            return "";
        }
        double dYuan = Double.parseDouble(yuan);
        DecimalFormat format = new DecimalFormat("#0.0#");
        return format.format(dYuan);
    }
    
    public static String formatMoney3(String yuan)
    {
        if(isNull(yuan)){
            return "";
        }
        double dYuan = Double.parseDouble(yuan);
        DecimalFormat format = new DecimalFormat("#0.00");
        return format.format(dYuan);
    }
    public static String formatMoney5(String yuan)
    {
        if(isNull(yuan)){
            return "";
        }
        double dYuan = Double.parseDouble(yuan);
        DecimalFormat format = new DecimalFormat("#0.00#");
        return format.format(dYuan);
    }
    /**
     * @Description 小数点2位后全舍去的方法
     * @param yuan
     * @return 
     * @Return String
     */
    public static String formatMoney4(String yuan)
    {
        if(isNull(yuan)){
            return "";
        }
        double dYuan = Double.parseDouble(yuan);
        DecimalFormat format = new DecimalFormat("#0.00");
        format.setRoundingMode(RoundingMode.FLOOR); 
        return format.format(dYuan);
    }


    /**
     * 
     * 功能描述：里转元方法
     * @param yuan
     * @return
     */
    public static String formatLMoneny(String li)
    {
        double dLi = Double.parseDouble(li);
        double dYuan = dLi / 1000;
        DecimalFormat format = new DecimalFormat("#0.00#");
        return format.format(dYuan);
    }
    
    /**
     * 分转元方法
     * @param money
     * @return
     */
    public static String formatFTYMoneny(String money)
    {
        if (money == null || money.trim().equals("") || money.equals("null"))
        {
            return "0";
        }
        try
        {
            double dmoney = Double.parseDouble(money);
            dmoney /= 100;
            DecimalFormat format = new DecimalFormat("#0.00");
            return format.format(dmoney);
        } catch (Exception e)
        {
            return "0";
        }
    }

    /**
     * 
     * 功能描述：元类型转换 去掉.00
     * @param yuan
     * @return
     */
    public static String formatYMoneny(String yuan)
    {
        double dYuan = Double.parseDouble(yuan);
        DecimalFormat format = new DecimalFormat("#");
        return format.format(dYuan);
    }

    /**
     * 
     * 功能描述：将字符串转化成大写，并将I转化成1，O转化成0；
     * @param str
     * @return
     */
    public static String toUpperCaseIgnoreIAndO(String str)
    {
        if (FuncUtils.isNull(str))
        {
            return null;
        }
        char[] chars = str.toUpperCase().toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == 'I')
            {
                chars[i] = '1';
            } else if (chars[i] == 'L')
            {
                chars[i] = '1';
            } else if (chars[i] == 'V')
            {
                chars[i] = 'W';
            } else if (chars[i] == 'O')
            {
                chars[i] = '0';
            } else if (chars[i] == 'M')
            {
                chars[i] = 'N';
            }
        }
        return new String(chars);
    }

    /**
     * 加密方法
     * @param str
     * @return
     */
    public static String encrytion(String str)
    {
        if (FuncUtils.isNull(str) || str.length() < 2)
        {
            return str;
        }
        int length = str.length();
        // 姓名加密
        if (length < 5)
        {
            return "*" + str.substring(1);
        }
        // 手机加密
        if (length == 11)
        {

            return str.substring(0, 3) + "****" + str.substring(7);
        }
        // 其他 末四位加密
        return str.substring(0, length - 4) + "**";

    }
    
    
    /**2013-07-05 21:46:18.0
     * yyyy-MM-dd,HH:mm:ss 转yyyyMMddHHmmss
     * @param date
     * @return
     */
    public static String transFormDate(String date){
        
        if(date!=null&&date.length()>18){
            return date.substring(0, 4)+date.substring(5, 7)
            +date.substring(8, 10)+date.substring(11, 13)+
            date.substring(14, 16)+date.substring(17, 19);
        }
        
        return date;
        
    }
    
    
    public static String subNum(String num1,String num2){
        Double numF=0.0;
        Double numL=0.0;
        if(!FuncUtils.isNull(num1)){
            numF=Double.valueOf(num1);
        }
        if(!FuncUtils.isNull(num2)){
            numL=Double.valueOf(num2);
        }
        
        double res=numF-numL;
        
        DecimalFormat format = new DecimalFormat("#0");
        return format.format(res);
    }
    
    public static boolean isBankCard(String str)
    {
    	if(isNull(str)){
    		return false;
    	}
        if (str.matches("^\\d{15,19}$"))
        {
            return true;
        } else
        {
            return false;
        }
    }
    
    /**
     * 功能描述：金额校验，必须大于0.01
     * @param money
     * @return
     */
    public static boolean isMoney(String money)
    {
        if (FuncUtils.isNull(money))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9]{0,}[.]{0,1}[0-9]{0,2}$");
        if (!pattern.matcher(money).matches())
        {
            return false;
        }
        if (Double.parseDouble(money) < 0.01)
        {
            return false;
        }
        return true;
    }
    
    /**
     * 功能描述：金额校验，必须大于0.01
     * @param money
     * @return
     */
    public static boolean isMoney2(String money)
    {
        if (FuncUtils.isNull(money))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9]{0,}[.]{0,1}[0-9]{0,1}$");
        if (!pattern.matcher(money).matches())
        {
            return false;
        }
        if (Double.parseDouble(money) < 0.1)
        {
            return false;
        }
        return true;
    }
    /**
     * 格式化银行卡 格式：6228 8745 8945 8945
     * 
     * @param bankcard
     * @return
     * @author zhufj
     */
    public static String formatBankCard(String bankcard)
    {
        if (isNull(bankcard))
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bankcard.length(); i++)
        {
            sb.append(bankcard.charAt(i));
            if ((i + 1) % 4 == 0)
            {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static boolean isMoney3(String money)
    {
        if (FuncUtils.isNull(money))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9]{0,}[.]{0,1}[0-9]{0,2}$");
        if (!pattern.matcher(money).matches())
        {
            return false;
        }
        if (Float.parseFloat(money) < 0.01)
        {
            return false;
        }
        return true;
    }
    public static boolean checkRefundMoney(String money)
    {
        if (FuncUtils.isNull(money))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9]{0,}[.]{0,1}[0-9]{0,2}$");
        if (!pattern.matcher(money).matches())
        {
            return false;
        }
        if(Float.parseFloat(money)==0){
        	return false;
        }
        return true;
    }
    
    
    /**
	 * 数字取整
	 * 
	 * @param numStr
	 * @return
	 */
	public static String intNumStr(String numStr) {
		if (FuncUtils.isNull(numStr)) {
			return numStr;
		}
		try {
			Double num = Double.parseDouble(numStr);
			int intNum = num.intValue();
			return String.valueOf(intNum);
		} catch (Exception e) {
			return numStr;
		}
	}
	public static boolean isNumber(String str)
    {
        Pattern pattern=Pattern.compile("[0-9]*");
        Matcher match=pattern.matcher(str);
        return match.matches();
    }

	
	 /**
     * 隐藏姓名 格式 *附件
     * 
     * @param name
     * @return
     * @author 
     */
    public static String hiddenName(String name)
    {
        if (isNull(name))
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("*");
        sb.append(name.substring(1));
        return sb.toString();
    }
    public static String parseString(String str){
    	if (isNull(str))
        {
            return "";
        }
    	return str;
    }
    
    /**
     * 隐藏身份证号的方法
     * @param idNo
     * @return 前六后四不隐藏 如：410527**********6718
     */
    public static String hiddenCertifiID1(String idNo)
    {
    	 if (isNull(idNo))
         {
             return "";
         }
    	idNo = idNo.trim();
        String head = idNo.substring(0, 6);
        String end = idNo.substring(idNo.length() - 4);
        String sbf = head;
        for (int i = 6; i < idNo.length() - 4; i++)
        {
            sbf += "*";
        }
        sbf += end;
        return sbf;
    }
    
    /**
     * 
     * @param money
     * @return
     * @author wuzf
     * @date 2017-7-8 上午9:55:50
     * @description:厘转元 保留两位小数，四舍五入
     * 
     */
    public static String formatWalletLTYMoney(Object money){
    	double yMoney = 0.0;
    	if(money == null){
    		return "0.00";
    	}
    	try{
    		yMoney = Double.parseDouble(money + "") / 1000;
    	}catch (Exception e) {
    		e.printStackTrace();
    		yMoney = 0.00;
		}
    	DecimalFormat df = new DecimalFormat("#0.00");
    	return df.format(yMoney);
    }
    
    public static void main(String args[]){
    	/*
    	System.out.println(formatMoney("12.0"));
    	System.out.println(formatMoney3("12.0"));
    	System.out.println(formatMoney(".00"));
    	System.out.println(formatMoney3(".00"));
    	System.out.println(formatMoney4("0.0123"));
    	System.out.println(formatMoney4(".00"));
    	System.out.println(formatMoney4("12.0"));
    	UserCheck reqObj=new UserCheck();
    	reqObj.setOid_userno("1111111111111111111111111111111111111das!@#$%^&*(&^%#$@#!^*&()*(*(+1111111111111111111");
    	System.out.println(JSON.toJSON(userCheckFormate(reqObj)));*/
    	
    	System.out.println(formatMoney5("1.")+"ssss");
    	
    }
    /**
    * 验证IP地址
    * 
    * @param 待验证的字符串
    * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
    */
    public static boolean isIP(String str) {
    	String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    	String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
    	return match(regex, str);
    }
    /**
    * @param regex
    * 正则表达式字符串
    * @param str
    * 要匹配的字符串
    * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
    */
    private static boolean match(String regex, String str) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(str);
    	return matcher.matches();
    }
    
    /** 
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址, 
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值 
     *  
     * @return ip
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for"); 
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("X-Real-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        } 
        return ip;  
    }
}
