package com.tencent.mobileqq.apollo.process.data;

import abmt;
import abos;
import abpf;
import abql;
import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class CmGameScreenRotate$1
  implements Runnable
{
  public CmGameScreenRotate$1(abpf paramabpf, int paramInt) {}
  
  public void run()
  {
    if (abpf.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = abmt.a(abpf.a(this.this$0).mGameId);
      } while (localObject == null);
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    if ((this.aJf == 0) || (this.aJf == 8))
    {
      if ((abpf.a(this.this$0) != null) && (abpf.a(this.this$0).getVisibility() == 0))
      {
        ((abql)localObject).setOrientation(false);
        abpf.a(this.this$0).setRequestedOrientation(this.aJf);
      }
      this.this$0.aUC = this.aJf;
      return;
    }
    ((abql)localObject).setOrientation(true);
    abpf.a(this.this$0).setRequestedOrientation(this.aJf);
    this.this$0.aUC = this.aJf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1
 * JD-Core Version:    0.7.0.1
 */