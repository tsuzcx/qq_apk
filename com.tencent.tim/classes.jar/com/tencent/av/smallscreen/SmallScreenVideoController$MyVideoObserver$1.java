package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmj;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iiv;
import ivz;
import ivz.b;
import iwb;

public class SmallScreenVideoController$MyVideoObserver$1
  implements Runnable
{
  public SmallScreenVideoController$MyVideoObserver$1(ivz.b paramb, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = aqmj.j(this.b.this$0.mContext);
    if (!((SharedPreferences)localObject1).getBoolean("kick_out_self", false))
    {
      if ((this.b.this$0.mSessionType != 1) && (this.b.this$0.mSessionType != 2)) {
        break label170;
      }
      if ((this.b.this$0.mPeerUin != null) && (this.Mu != null) && (this.b.this$0.mPeerUin.equals(this.Mu)))
      {
        this.b.this$0.Ox = this.VF;
        this.b.this$0.finish();
      }
      if (this.b.this$0.jdField_a_of_type_Iwb != null)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putInt("video_position", this.b.this$0.jdField_a_of_type_Iwb.getPosition());
        ((SharedPreferences.Editor)localObject1).commit();
      }
    }
    label170:
    label306:
    do
    {
      for (;;)
      {
        return;
        if ((this.b.this$0.mSessionType != 3) && (this.b.this$0.mSessionType != 4)) {
          break;
        }
        if (this.b.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label297;
          }
        }
        for (localObject1 = localObject2;; localObject1 = String.valueOf(((iiv)localObject1).ll))
        {
          if ((localObject1 == null) || (this.Mu == null) || (!((String)localObject1).equals(this.Mu))) {
            break label306;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
          }
          this.b.this$0.Ox = this.VF;
          this.b.this$0.finish();
          return;
          localObject1 = this.b.this$0.jdField_a_of_type_ComTencentAvVideoController.b();
          break;
        }
      }
    } while ((this.b.this$0.mSessionType != 0) || (!this.b.this$0.Ta) || ((this.b.this$0.auH != 1) && (this.b.this$0.auH != 2)));
    label297:
    this.b.this$0.Ox = this.VF;
    this.b.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1
 * JD-Core Version:    0.7.0.1
 */