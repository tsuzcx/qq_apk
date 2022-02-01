package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.EditText;
import apkt;
import aplj;
import aplj.a;

public class TextItem$6
  implements Runnable
{
  public TextItem$6(aplj paramaplj, aplj.a parama, apkt paramapkt) {}
  
  public void run()
  {
    this.a.mEditText.requestFocus();
    this.a.mEditText.findFocus();
    this.a.mEditText.setSelection(this.b.dUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6
 * JD-Core Version:    0.7.0.1
 */