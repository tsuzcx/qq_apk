package com.tencent.tbs.reader.external;

public class TbsReaderTokenAtom
  implements ITbsReaderAtom
{
  private ITbsReaderAtom mAtomImp;
  
  public TbsReaderTokenAtom(ITbsReaderAtom paramITbsReaderAtom)
  {
    this.mAtomImp = paramITbsReaderAtom;
  }
  
  public int getAtomType()
  {
    return 1;
  }
  
  public int init(Object paramObject)
  {
    if (this.mAtomImp != null) {
      return this.mAtomImp.init(paramObject);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.external.TbsReaderTokenAtom
 * JD-Core Version:    0.7.0.1
 */