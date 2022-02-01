package com.tencent.qqmail.card;

public class CardSendTypeEnum
{
  public static final int CARD_SEND_FRIENDTYPE_ALL = 3;
  public static final int CARD_SEND_FRIENDTYPE_QQ = 1;
  public static final int CARD_SEND_FRIENDTYPE_QQHOT = 2;
  public static final int CARD_SEND_FRIENDTYPE_RECENT = 0;
  public static final int CARD_SEND_PAGE_TYPE_NORMAL = 0;
  public static final int CARD_SEND_PAGE_TYPE_POPULAR = 1;
  public static final int CARD_SEND_SEQ_TYPE_ORDER = 1;
  public static final int CARD_SEND_SEQ_TYPE_RANDOM = 0;
  public static final String SEND_TO_ALL = "all";
  public static final String SEND_TO_HOT = "hot";
  public static final String SEND_TO_QQ = "qq";
  public static final String SEND_TO_QQ_HOT = "qqhot";
  
  public static String getSchemaTo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "hot";
    case 0: 
      return "hot";
    case 1: 
      return "qq";
    case 2: 
      return "qqhot";
    }
    return "all";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.CardSendTypeEnum
 * JD-Core Version:    0.7.0.1
 */