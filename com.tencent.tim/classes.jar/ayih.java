import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ayih
  extends aygy
  implements ayfb, IEventReceiver
{
  private int eKk;
  private int mState = 0;
  private TransferData mTransferData = new TransferData();
  
  public ayih(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private boolean aQG()
  {
    return (this.mTransferData.mConfigData.mID != -1) && (this.mTransferData.getPositions().size() > 0);
  }
  
  public static long iZ()
  {
    return -200L;
  }
  
  public static int lZ(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return -1;
  }
  
  private void on(long paramLong)
  {
    Object localObject = this.mTransferData.getPositions();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      this.mState = 1;
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    Long localLong;
    for (long l = 0L; ((Iterator)localObject).hasNext(); l = localLong.longValue())
    {
      localLong = (Long)((Iterator)localObject).next();
      if (localLong.longValue() - l < 2000L)
      {
        this.mState = 2;
        return;
      }
    }
    if (paramLong - l < 2000L)
    {
      this.mState = 2;
      return;
    }
    this.mState = 0;
  }
  
  public int RQ()
  {
    return this.mState;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (!aQF()) {}
    String str;
    do
    {
      return;
      str = this.mTransferData.toJSONObject();
    } while (TextUtils.isEmpty(str));
    paramayqb.g.putExtra("transfer_effect_data", str);
  }
  
  public boolean aQF()
  {
    return this.mState == 0;
  }
  
  public void afc(int paramInt)
  {
    Object localObject = TransferConfig.getConfigData(paramInt);
    if (paramInt == 1)
    {
      ((TransferConfig.ConfigData)localObject).mCommonFloat1 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat2 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat3 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat4 = null;
    }
    this.mTransferData.setConfigData((TransferConfig.ConfigData)localObject);
    if (aQG())
    {
      localObject = (ayhm)a(ayhm.class);
      if (localObject != null) {
        ((ayhm)localObject).setTransferData(this.mTransferData);
      }
    }
  }
  
  public void cm(JSONObject paramJSONObject)
  {
    try
    {
      if (aQF()) {
        paramJSONObject.put("EditVideoTransfer", this.mTransferData.toJSONObject());
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.mState != 0) {}
    do
    {
      return;
      if (paramInt2 == 42)
      {
        this.eKk = this.mTransferData.mConfigData.mID;
        afc(-1);
        return;
      }
    } while (paramInt1 != 42);
    afc(this.eKk);
  }
  
  public void eRa()
  {
    if (this.mState == 1) {
      QQToast.a(getContext(), 2131721267, 0).show();
    }
    while (this.mState != 2) {
      return;
    }
    QQToast.a(getContext(), 2131721266, 0).show();
  }
  
  public void onCreate()
  {
    a(ayfb.class, this);
    if ((this.b.a.a instanceof EditLocalPhotoSource)) {
      this.mState = 3;
    }
    for (;;)
    {
      if (this.mState == 0)
      {
        localObject = ((axpr)axov.a(5)).a;
        if (localObject != null)
        {
          localObject = ((ayva.a)localObject).b();
          afc(Integer.parseInt(((TransitionCategoryItem)localObject).id));
          ayva.a().a((TransitionCategoryItem)localObject);
          localObject = (ayeg)a(ayeg.class);
          if ((localObject != null) && (!(this.b instanceof aytw))) {
            ((ayeg)localObject).eQM();
          }
        }
        if (AudioHelper.aCA()) {
          this.mTransferData.setReverseShift(iZ());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onCreate, state:" + this.mState);
      }
      Object localObject = (ayde)a(ayde.class);
      if (this.mState != 0) {
        ((ayde)localObject).eQJ();
      }
      rar.a("video_edit_transition", "exp_transition", lZ(this.b.a.getIntExtra("extra_transiton_src_from", -1)), 0, new String[0]);
      return;
      if ((this.b.a.a instanceof EditLocalVideoSource))
      {
        this.mState = 3;
      }
      else if ((this.b.a.a instanceof EditTakeVideoSource))
      {
        this.mTransferData.setPositions(((EditTakeVideoSource)this.b.a.a).d.mTransferPosList);
        if (this.b.a.getIntExtra("extra_transiton_src_from", -1) == 1) {
          this.mState = 0;
        } else {
          on(((EditTakeVideoSource)this.b.a.a).d.mDuration);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayih
 * JD-Core Version:    0.7.0.1
 */