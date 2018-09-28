package com.jack.utils;

/**
 * 与字符串有关的操作工具类
 *
 * @author chengqian
 * Created on 2018/7/14
 */
public class StringUtils {
    /**
     * 根据用户名的不同长度来进行替换，达到保密效果
     *
     * @param userName 用户名
     * @return 替换后的用户名
     */
    public static String userNameReplaceWithStar(String userName) {
        String userNameAfterReplaced = "";
        if (userName == null) {
            userName = "";
        }
        int nameLength = userName.length();
        if (nameLength <= 1) {
            userNameAfterReplaced = "*";
        } else if (nameLength == 2) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{0})\\d(?=\\d{1})");
        } else if (nameLength >= 3 && nameLength <= 6) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{1})\\d(?=\\d{1})");
        } else if (nameLength == 7) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{1})\\d(?=\\d{2})");
        } else if (nameLength == 8) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{2})\\d(?=\\d{2})");
        } else if (nameLength == 9) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{2})\\d(?=\\d{3})");
        } else if (nameLength == 10) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{3})\\d(?=\\d{3})");
        } else {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\d{3})\\d(?=\\d{4})");
        }
        return userNameAfterReplaced;
    }

    /**
     * 实际替换动作
     *
     * @param userName 用户名
     * @param regular  正则
     * @return 替换结果
     */
    private static String replaceAction(String userName, String regular) {
        return userName.replaceAll(regular, "");
    }

    /**
     * 身份证号替换，保留前四位和后四位
     * <p>
     * 如果身份证号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     *
     * @param idCard 身份证号
     * @return 替换结果
     */
    public static String idCardReplaceWithStar(String idCard) {
        if (idCard == null || idCard.isEmpty()) {
            return null;
        } else {
            return replaceAction(idCard, "(?<=\\d{4})\\d(?=\\d{4})");
        }
    }

    /**
     * 银行卡替换，保留后四位
     * 如果银行卡号为空或null,返回null；否则，返回替换后的字符串；
     *
     * @param bankCard 银行卡号
     * @return 替换结果
     */
    public static String bankCardReplaceWithStar(String bankCard) {
        if (bankCard == null || bankCard.isEmpty()) {
            return null;
        } else {
            return replaceAction(bankCard, "(?<=\\d{0})\\d(?=\\d{4})");
        }
    }
}
