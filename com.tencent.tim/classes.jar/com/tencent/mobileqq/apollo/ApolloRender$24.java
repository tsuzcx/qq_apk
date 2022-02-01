package com.tencent.mobileqq.apollo;

import android.widget.EditText;

final class ApolloRender$24
  implements Runnable
{
  ApolloRender$24(ApolloRender paramApolloRender, String paramString) {}
  
  public void run()
  {
    if ((this.b.mEditorPop != null) && (this.b.mEditorPop.getText().toString().compareToIgnoreCase(this.bgj) != 0))
    {
      this.b.mEditorPop.setText(this.bgj);
      this.b.mEditorPop.setSelection(this.bgj.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.24
 * JD-Core Version:    0.7.0.1
 */