public abstract class iww
{
  protected int CP = 1;
  protected int LO = 3;
  protected String QR;
  protected int avf = 0;
  protected int mId;
  protected int mLevel;
  
  protected iww(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.mId = paramInt1;
    this.mLevel = paramInt2;
    this.LO = paramInt3;
    this.CP = paramInt4;
    this.QR = paramString;
  }
  
  public static boolean a(iww paramiww1, iww paramiww2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramiww2 == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramiww1 == null);
          i = paramiww2.getLevel();
          j = paramiww1.getLevel();
          ikz.ja("CheckAvTipsItemLevelCanShow, lvNew[" + i + "], lvOld[" + j + "], idNew[" + paramiww2.getID() + "], idOld[" + paramiww1.getID() + "]");
          bool1 = bool2;
        } while (i < j);
        if (i > j) {
          return false;
        }
        bool1 = bool2;
      } while (paramiww1.vS());
      if (paramiww2.vS()) {
        return false;
      }
      bool1 = bool2;
    } while (paramiww2.lN() <= paramiww1.lN());
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof iww))) {}
    do
    {
      return false;
      paramObject = (iww)paramObject;
    } while (getID() != paramObject.getID());
    return true;
  }
  
  public int getID()
  {
    return this.mId;
  }
  
  public int getLevel()
  {
    return this.mLevel;
  }
  
  public int getShowType()
  {
    return this.CP;
  }
  
  public String hj()
  {
    return this.QR;
  }
  
  public void jN(String paramString)
  {
    if (paramString != null) {
      this.QR = paramString;
    }
  }
  
  public abstract int lM();
  
  public int lN()
  {
    return this.LO;
  }
  
  public void lY(int paramInt)
  {
    this.LO = paramInt;
  }
  
  public boolean vS()
  {
    return this.LO == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iww
 * JD-Core Version:    0.7.0.1
 */