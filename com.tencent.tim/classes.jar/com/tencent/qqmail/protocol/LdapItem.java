package com.tencent.qqmail.protocol;

import java.io.Serializable;

public class LdapItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String common_name_;
  public String[] department_list_;
  public int expire_days_ = -1;
  public String[] mail_list_;
  public String[] mail_nick_name_list_;
  public String[] members_cn_list_;
  public String[] mobile_list_;
  public String[] telephone_list_;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.LdapItem
 * JD-Core Version:    0.7.0.1
 */