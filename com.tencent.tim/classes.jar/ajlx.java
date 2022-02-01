import com.tencent.qphone.base.util.QLog;

class ajlx
  extends akye.a
{
  ajlx(ajlu paramajlu, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, akxr paramakxr)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.val$id + ", result = " + paramInt);
    }
    ajlq localajlq = this.e.a(this.val$key);
    if ((localajlq != null) && (!localajlq.isCompleted))
    {
      localajlq.result = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localajlq.jdField_a_of_type_Ajlp.fileType = 1;
      if (paramakxr == null) {
        break label236;
      }
      localajlq.result = paramakxr.mResult;
      if ((paramakxr.mResult != 0) && (paramakxr.c != null))
      {
        localajlq.errorCode = paramakxr.c.errCode;
        localajlq.errorMessage = paramakxr.c.bUJ;
      }
      if (paramakxr.mResult != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramakxr.bjc;; bool = false)
    {
      localajlq.jdField_a_of_type_Ajmh = new ajmh(this.val$id, this.bWI, this.val$type, paramInt, this.aWm, bool);
      this.e.a(this.val$key, localajlq);
      ajlu.a(this.e, localajlq.jdField_a_of_type_Ajlp, 0, localajlq.errorCode, localajlq.errorMessage);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
    }
  }
  
  public void aO(int paramInt, boolean paramBoolean)
  {
    if (this.e.c != null) {
      this.e.c.b(this.val$id, this.bWI, this.val$type, paramInt, this.val$fileSize, paramBoolean);
    }
    ajlq localajlq = this.e.a(this.val$key);
    if ((localajlq != null) && (!localajlq.isCompleted))
    {
      if (ajlu.a(this.e)) {
        ajlu.a(this.e, localajlq.jdField_a_of_type_Ajlp, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localajlq.progress = paramInt;
    this.e.a(this.val$key, localajlq);
    ajlu.b(this.e, localajlq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlx
 * JD-Core Version:    0.7.0.1
 */