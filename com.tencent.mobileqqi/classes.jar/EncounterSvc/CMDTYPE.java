package EncounterSvc;

import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final CMDTYPE CMD_CHECK_IN_CRC;
  public static final CMDTYPE CMD_CHECK_IN_NB;
  public static final CMDTYPE CMD_GET_ENCOUNTER;
  public static final CMDTYPE CMD_GET_ENCOUNTERV2;
  public static final CMDTYPE CMD_GET_ENCOUNTER_CRC;
  public static final CMDTYPE CMD_GET_USERINFO_FROMNB;
  public static final CMDTYPE CMD_INIT;
  public static final int _CMD_CHECK_IN_CRC = 103;
  public static final int _CMD_CHECK_IN_NB = 101;
  public static final int _CMD_GET_ENCOUNTER = 1;
  public static final int _CMD_GET_ENCOUNTERV2 = 3;
  public static final int _CMD_GET_ENCOUNTER_CRC = 2;
  public static final int _CMD_GET_USERINFO_FROMNB = 102;
  public static final int _CMD_INIT = 0;
  private static CMDTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMDTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CMDTYPE[7];
      CMD_INIT = new CMDTYPE(0, 0, "CMD_INIT");
      CMD_GET_ENCOUNTER = new CMDTYPE(1, 1, "CMD_GET_ENCOUNTER");
      CMD_GET_ENCOUNTER_CRC = new CMDTYPE(2, 2, "CMD_GET_ENCOUNTER_CRC");
      CMD_GET_ENCOUNTERV2 = new CMDTYPE(3, 3, "CMD_GET_ENCOUNTERV2");
      CMD_CHECK_IN_NB = new CMDTYPE(4, 101, "CMD_CHECK_IN_NB");
      CMD_GET_USERINFO_FROMNB = new CMDTYPE(5, 102, "CMD_GET_USERINFO_FROMNB");
      CMD_CHECK_IN_CRC = new CMDTYPE(6, 103, "CMD_CHECK_IN_CRC");
      return;
    }
  }
  
  private CMDTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static CMDTYPE convert(int paramInt)
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
  
  public static CMDTYPE convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     EncounterSvc.CMDTYPE
 * JD-Core Version:    0.7.0.1
 */