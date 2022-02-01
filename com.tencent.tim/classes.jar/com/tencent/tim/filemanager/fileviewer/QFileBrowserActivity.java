package com.tencent.tim.filemanager.fileviewer;

import agsa;
import android.content.Intent;
import android.widget.RelativeLayout.LayoutParams;
import atxf;
import atxg;
import com.tencent.qphone.base.util.QLog;

public class QFileBrowserActivity
  extends FileBrowserActivity
  implements agsa
{
  protected boolean U(Intent paramIntent)
  {
    atxg localatxg = new atxg(this.app);
    if (!localatxg.a(paramIntent, this)) {
      if (QLog.isColorLevel()) {
        QLog.i("QFileBrowserActivity", 1, "createFromIntent : file params error, can not be parser.");
      }
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_Atxf == null)
      {
        this.jdField_a_of_type_Atxf = new atxf(this, this, localatxg.a(this));
        this.jdField_a_of_type_Atxf.a(this.jdField_a_of_type_Atyr);
      }
      if (this.jdField_a_of_type_Atxf.b(a(), new RelativeLayout.LayoutParams(-1, -1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QFileBrowserActivity", 2, "error. can not create a file viewer from FileBrowserManager");
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.QFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */