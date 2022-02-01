package NeighborComm;

import java.io.Serializable;

public final class NewListType
  implements Serializable
{
  public static final NewListType NewListType_Encounter_Number;
  public static final NewListType NewListType_Nomal;
  public static final NewListType NewListType_None;
  public static final NewListType NewListType_Only_Female;
  public static final NewListType NewListType_Only_Male;
  public static final NewListType NewListType_RankingList;
  public static final NewListType NewListType_Recommend;
  public static final NewListType NewListType_Single;
  public static final NewListType NewListType_Tag;
  public static final int _NewListType_Encounter_Number = 6;
  public static final int _NewListType_Nomal = 0;
  public static final int _NewListType_None = 100;
  public static final int _NewListType_Only_Female = 1;
  public static final int _NewListType_Only_Male = 2;
  public static final int _NewListType_RankingList = 4;
  public static final int _NewListType_Recommend = 7;
  public static final int _NewListType_Single = 5;
  public static final int _NewListType_Tag = 3;
  private static NewListType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!NewListType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new NewListType[9];
      NewListType_Nomal = new NewListType(0, 0, "NewListType_Nomal");
      NewListType_Only_Female = new NewListType(1, 1, "NewListType_Only_Female");
      NewListType_Only_Male = new NewListType(2, 2, "NewListType_Only_Male");
      NewListType_Tag = new NewListType(3, 3, "NewListType_Tag");
      NewListType_RankingList = new NewListType(4, 4, "NewListType_RankingList");
      NewListType_Single = new NewListType(5, 5, "NewListType_Single");
      NewListType_Encounter_Number = new NewListType(6, 6, "NewListType_Encounter_Number");
      NewListType_Recommend = new NewListType(7, 7, "NewListType_Recommend");
      NewListType_None = new NewListType(8, 100, "NewListType_None");
      return;
    }
  }
  
  private NewListType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static NewListType convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static NewListType convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NeighborComm.NewListType
 * JD-Core Version:    0.7.0.1
 */