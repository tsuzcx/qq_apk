package com.tencent.tbs.reader.external;

public class TbsReaderAdvAtom
  implements ITbsReaderEditAtom
{
  protected ITbsReaderEditAtom mReaderAtom;
  
  public TbsReaderAdvAtom(ITbsReaderEditAtom paramITbsReaderEditAtom)
  {
    this.mReaderAtom = paramITbsReaderEditAtom;
  }
  
  public void destory()
  {
    this.mReaderAtom = null;
  }
  
  public void enterEditMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.enterEditMode();
    }
  }
  
  public void enterFindMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.enterFindMode();
    }
  }
  
  public void enterFitScreen()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.enterFitScreen();
    }
  }
  
  public void enterPlayMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.enterPlayMode();
    }
  }
  
  public void exitEditMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.exitEditMode();
    }
  }
  
  public void exitFindMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.exitFindMode();
    }
  }
  
  public void exitFitScreen()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.exitFitScreen();
    }
  }
  
  public void exitPlayMode()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.exitPlayMode();
    }
  }
  
  public void findNext()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.findNext();
    }
  }
  
  public void findPrev()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.findPrev();
    }
  }
  
  public int getAtomType()
  {
    return 2;
  }
  
  public void getOutLineData()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.getOutLineData();
    }
  }
  
  public int init(Object paramObject)
  {
    if (this.mReaderAtom != null) {
      return this.mReaderAtom.init(paramObject);
    }
    return -1;
  }
  
  public boolean isDocModified()
  {
    if (this.mReaderAtom != null) {
      return this.mReaderAtom.isDocModified();
    }
    return false;
  }
  
  public boolean qryFitScreenMode()
  {
    if (this.mReaderAtom != null) {
      return this.mReaderAtom.qryFitScreenMode();
    }
    return false;
  }
  
  public void revertEdit()
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.revertEdit();
    }
  }
  
  public void saveDoc(String paramString)
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.saveDoc(paramString);
    }
  }
  
  public void setDecryptPassWord(String paramString)
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.setDecryptPassWord(paramString);
    }
  }
  
  public void setExcelEditBarBottomMargin(int paramInt)
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.setExcelEditBarBottomMargin(paramInt);
    }
  }
  
  public void setFindText(String paramString)
  {
    if (this.mReaderAtom != null) {
      this.mReaderAtom.setFindText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.external.TbsReaderAdvAtom
 * JD-Core Version:    0.7.0.1
 */