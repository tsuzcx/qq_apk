package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.utilities.QMMath;

public class MailRuleInfo
{
  public static final int ACTION_MARK = 1;
  public static final int ACTION_MOVE = 0;
  public static final String ALIAS_MOVETO = "moveto";
  public static final String ALIAS_NONE = "";
  public static final String ALIAS_REJECT = "reject";
  public static final int FIELD_NAME_ADDRESS = 0;
  public static final int FIELD_NAME_SUBJECT = 1;
  public static final int OPERATOR_CONTAIN = 1;
  public static final int OPERATOR_EQUAL = 0;
  private int accountId;
  private int action;
  private String alias;
  private int fieldName;
  private int id;
  private int operator;
  private String param;
  private String val;
  private String val2;
  
  public static int generateId(String paramString1, int paramInt, String paramString2)
  {
    return QMMath.hashInt(paramString1 + "_" + paramInt + "_" + paramString2);
  }
  
  public int generateId()
  {
    return generateId(this.alias, this.accountId, this.val + this.val2);
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public int getFieldName()
  {
    return this.fieldName;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getOperator()
  {
    return this.operator;
  }
  
  public String getParam()
  {
    return this.param;
  }
  
  public String getVal()
  {
    return this.val;
  }
  
  public String getVal2()
  {
    return this.val2;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setFieldName(int paramInt)
  {
    this.fieldName = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setOperator(int paramInt)
  {
    this.operator = paramInt;
  }
  
  public void setParam(String paramString)
  {
    this.param = paramString;
  }
  
  public void setVal(String paramString)
  {
    this.val = paramString;
  }
  
  public void setVal2(String paramString)
  {
    this.val2 = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.MailRuleInfo
 * JD-Core Version:    0.7.0.1
 */