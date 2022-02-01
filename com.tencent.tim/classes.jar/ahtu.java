import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

final class ahtu
  implements BusinessObserver
{
  ahtu(WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2, AIOImageData paramAIOImageData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetArkTailRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.Util", 2, "GetArkTailRspFromGallery:" + paramBoolean + "|" + paramBundle);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      Object localObject = (Context)this.aD.get();
      TextView localTextView = (TextView)this.aE.get();
      xtj localxtj = (xtj)this.aF.get();
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing()) && (localTextView != null) && (localxtj != null) && (localxtj.b() != null) && (localxtj.b().e != null) && (localxtj.b().e.id == this.val$id) && (localxtj.b().e.subId == this.aaV))
      {
        localTextView.setText(paramBundle.desc);
        localTextView.setTag(-1, paramBundle.jump_url);
        localTextView.setTag(-2, Integer.valueOf(paramBundle.type));
        localTextView.setTag(-3, Integer.valueOf(paramBundle.sub_type));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("game_source_pic_txt", paramBundle.desc);
      ((Bundle)localObject).putString("game_source_pic_url", paramBundle.jump_url);
      ((Bundle)localObject).putInt("game_source_type_pic", paramBundle.type);
      ((Bundle)localObject).putInt("game_source_subtype_pic", paramBundle.sub_type);
      ((Bundle)localObject).putLong("uniseq", this.a.id);
      ((Bundle)localObject).putInt("is_troop", this.a.istroop);
      ((Bundle)localObject).putString("friend_uin", this.a.aWk);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "saveGalleryDataToMsg", (Bundle)localObject, null);
      localObject = (StructMsgForImageShare)anre.a((byte[])this.a.bQ);
      ahtr.a(this.a, (StructMsgForImageShare)localObject, paramBundle.desc, paramBundle.jump_url, paramBundle.type, paramBundle.sub_type, true);
      ahtr.b(((StructMsgForImageShare)localObject).mSourceAppid + "", paramBundle.sub_type, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtu
 * JD-Core Version:    0.7.0.1
 */