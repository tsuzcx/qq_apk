import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class aubr
  extends auby
{
  public aubr(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
  }
  
  private void dke()
  {
    int i = this.jdField_a_of_type_Atzy.bI();
    int j = this.jdField_a_of_type_Atzy.bF();
    switch (this.jdField_a_of_type_Atzy.getFileType())
    {
    default: 
      this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131693705));
      switch (i)
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter", 2, "getFileTips: opType[" + i + "not implemented");
        }
        break;
      }
      break;
    }
    do
    {
      return;
      this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131693704));
      break;
      this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131693706));
      break;
      switch (j)
      {
      case 10: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + j + "not implemented");
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_Aucs.JJ(false);
        return;
        this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131696563));
        continue;
        this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131696566));
        continue;
        this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131696567));
      }
      switch (j)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("SimpleFilePresenter", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + j + "not implemented");
    return;
    this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131696562));
    this.jdField_a_of_type_Aucs.JJ(false);
    return;
    this.jdField_a_of_type_Aucs.JK(false);
    this.jdField_a_of_type_Aucs.JJ(false);
    this.jdField_a_of_type_Aucs.Jt(this.mContext.getString(2131696567));
  }
  
  public void djH()
  {
    djX();
    dke();
  }
  
  protected void djT()
  {
    super.djT();
    int i = this.jdField_a_of_type_Atzy.bF();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_Aucs.JJ(false);
    }
  }
  
  public void init()
  {
    super.init();
    this.jdField_a_of_type_Aucs.Js(aueh.g(this.jdField_a_of_type_Atzy.getFileSize()));
    dke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubr
 * JD-Core Version:    0.7.0.1
 */