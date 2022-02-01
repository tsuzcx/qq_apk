package com.tencent.mobileqq.emoticon;

import afkd;
import afke;
import aflb;
import aflf;
import ajdg;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SogouEmoji$3
  implements Runnable
{
  public SogouEmoji$3(aflb paramaflb, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey begins, packId=" + this.bDS + ",exprId:" + this.bDR + ",isNewTask:" + this.bYM);
    }
    Object localObject;
    if (this.this$0.e.b(this.bDS) == null)
    {
      this.this$0.cRR = this.this$0.jdField_a_of_type_Aflf.J(this.bDS, this.bDR);
      localObject = new Bundle();
      ((Bundle)localObject).putInt(aflb.bDP, this.this$0.cRR);
      ((Bundle)localObject).putString(aflb.bDQ, this.bDR);
      afkd.a().a(this.this$0.jdField_a_of_type_Afko);
      this.this$0.c.a(this.bDS, afke.cRu, (Bundle)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey ends, fail to search 【the pack】 from db, try get json from srv, mCurTaskId:" + this.this$0.cRR);
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.this$0.e.a(this.bDS, this.bDR);
        if (localObject != null) {
          break;
        }
        this.this$0.cRR = this.this$0.jdField_a_of_type_Aflf.J(this.bDS, this.bDR);
        localObject = new Bundle();
        ((Bundle)localObject).putInt(aflb.bDP, this.this$0.cRR);
        ((Bundle)localObject).putString(aflb.bDQ, this.bDR);
        afkd.a().a(this.this$0.jdField_a_of_type_Afko);
        this.this$0.c.a(this.bDS, afke.cRu, (Bundle)localObject, false);
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey ends, fail to search 【the emotion】 from db, try get json from srv, mCurTaskId:" + this.this$0.cRR);
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      if (this.bYM) {
        this.this$0.cRR = this.this$0.jdField_a_of_type_Aflf.J(this.bDS, this.bDR);
      }
      this.this$0.v(this.bDS, localArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey ends, everything is ok, try get keys from svr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.3
 * JD-Core Version:    0.7.0.1
 */