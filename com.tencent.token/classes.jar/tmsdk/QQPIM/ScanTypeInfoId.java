package tmsdk.QQPIM;

import java.io.Serializable;

public final class ScanTypeInfoId
  implements Serializable
{
  public static final ScanTypeInfoId SPECIAL_CIQ_VIRUS;
  public static final ScanTypeInfoId SPECIAL_KUNGFU_VIRUS;
  public static final ScanTypeInfoId SPECIAL_SMISHING_VIRUS;
  public static final ScanTypeInfoId SYSTEM_FLAW_ACCOUNT_CHEAT;
  public static final ScanTypeInfoId SYSTEM_FLAW_DATACLEAR;
  public static final ScanTypeInfoId SYSTEM_FLAW_MASTERKEY;
  public static final ScanTypeInfoId SYSTEM_FLAW_ROOT;
  public static final ScanTypeInfoId SYSTEM_FLAW_S4_CLOUDBACKUP;
  public static final ScanTypeInfoId SYSTEM_FLAW_SMISHING;
  public static final int _SPECIAL_CIQ_VIRUS = 110003;
  public static final int _SPECIAL_KUNGFU_VIRUS = 110001;
  public static final int _SPECIAL_SMISHING_VIRUS = 110002;
  public static final int _SYSTEM_FLAW_ACCOUNT_CHEAT = 120006;
  public static final int _SYSTEM_FLAW_DATACLEAR = 120002;
  public static final int _SYSTEM_FLAW_MASTERKEY = 120005;
  public static final int _SYSTEM_FLAW_ROOT = 120003;
  public static final int _SYSTEM_FLAW_S4_CLOUDBACKUP = 120004;
  public static final int _SYSTEM_FLAW_SMISHING = 120001;
  private static ScanTypeInfoId[] eT;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!ScanTypeInfoId.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      eT = new ScanTypeInfoId[9];
      SPECIAL_KUNGFU_VIRUS = new ScanTypeInfoId(0, 110001, "SPECIAL_KUNGFU_VIRUS");
      SPECIAL_SMISHING_VIRUS = new ScanTypeInfoId(1, 110002, "SPECIAL_SMISHING_VIRUS");
      SPECIAL_CIQ_VIRUS = new ScanTypeInfoId(2, 110003, "SPECIAL_CIQ_VIRUS");
      SYSTEM_FLAW_SMISHING = new ScanTypeInfoId(3, 120001, "SYSTEM_FLAW_SMISHING");
      SYSTEM_FLAW_DATACLEAR = new ScanTypeInfoId(4, 120002, "SYSTEM_FLAW_DATACLEAR");
      SYSTEM_FLAW_ROOT = new ScanTypeInfoId(5, 120003, "SYSTEM_FLAW_ROOT");
      SYSTEM_FLAW_S4_CLOUDBACKUP = new ScanTypeInfoId(6, 120004, "SYSTEM_FLAW_S4_CLOUDBACKUP");
      SYSTEM_FLAW_MASTERKEY = new ScanTypeInfoId(7, 120005, "SYSTEM_FLAW_MASTERKEY");
      SYSTEM_FLAW_ACCOUNT_CHEAT = new ScanTypeInfoId(8, 120006, "SYSTEM_FLAW_ACCOUNT_CHEAT");
      return;
    }
  }
  
  private ScanTypeInfoId(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    eT[paramInt1] = this;
  }
  
  public static ScanTypeInfoId convert(int paramInt)
  {
    int i = 0;
    while (i < eT.length)
    {
      if (eT[i].value() == paramInt) {
        return eT[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ScanTypeInfoId convert(String paramString)
  {
    int i = 0;
    while (i < eT.length)
    {
      if (eT[i].toString().equals(paramString)) {
        return eT[i];
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
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ScanTypeInfoId
 * JD-Core Version:    0.7.0.1
 */