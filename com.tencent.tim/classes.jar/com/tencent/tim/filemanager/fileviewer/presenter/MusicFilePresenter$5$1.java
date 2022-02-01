package com.tencent.tim.filemanager.fileviewer.presenter;

import atyk;
import aubn;
import aucq;

class MusicFilePresenter$5$1
  implements Runnable
{
  MusicFilePresenter$5$1(MusicFilePresenter.5 param5) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_Atyk != null) && (this.a.this$0.jdField_a_of_type_Atyk.mD(aubn.a(this.a.this$0))))
    {
      int i = this.a.this$0.jdField_a_of_type_Atyk.getCurrentPosition();
      this.a.this$0.OB(i);
      this.a.this$0.jdField_a_of_type_Aucq.OL(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.presenter.MusicFilePresenter.5.1
 * JD-Core Version:    0.7.0.1
 */