package com.ml.uilts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther:ml
 * @Date:2022/12/23 - 12 - 23 - 9:01
 * @Description:com.ml.uilts
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    //用户编号
    private Long id;
    //状态码
    private int code;
    //token令牌
    private String token;
    //token过期时间
    private Long expireTime;
}
