import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class ayfc
  extends aygy
  implements IEventReceiver
{
  private ayfc.a a;
  
  public ayfc(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_a_of_type_Ayfc$a = new ayfc.a(this.b);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      int i;
      DynamicTextConfigManager localDynamicTextConfigManager;
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "handle message MESSAGE_DOODLE_LAYOUT_LOADED");
        }
        Object localObject = (EditVideoParams)this.jdField_a_of_type_Ayii.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
        i = ((EditVideoParams)localObject).getIntExtra("extra_slide_sticker_id", -1);
        localObject = ((EditVideoParams)localObject).getStringExtra("extra_slide_sticker_str");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (i == -1)) {
          continue;
        }
        localDynamicTextConfigManager = (DynamicTextConfigManager)axov.a(7);
        if (!localDynamicTextConfigManager.aPL()) {
          localDynamicTextConfigManager.eOS();
        }
        localDynamicTextConfigBean = localDynamicTextConfigManager.a(i + "");
        if (localDynamicTextConfigBean == null) {
          continue;
        }
        if (!localDynamicTextConfigManager.a(localDynamicTextConfigBean)) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "isDynamicTextUsable, addSticker : " + localDynamicTextConfigBean.text_id);
        }
        this.b.eJ(i, (String)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.d("EditVideoAblumList", 2, aurp.getStackTraceAsString(localException));
        continue;
        label226:
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "configBean has not downloaded, start download : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_Ayfc$a.afd(i);
        this.jdField_a_of_type_Ayfc$a.ady(localException);
        localDynamicTextConfigManager.a(localDynamicTextConfigBean, this.jdField_a_of_type_Ayfc$a);
      }
    }
  }
  
  public void onCreate()
  {
    ayeg localayeg = (ayeg)a(ayeg.class);
    if (localayeg != null) {
      localayeg.eQO();
    }
  }
  
  static class a
    implements DynamicTextConfigManager.b
  {
    private aygz b;
    private String cWR = "";
    private int stickerId = -1;
    
    public a(aygz paramaygz)
    {
      this.b = paramaygz;
    }
    
    public void a(float paramFloat, String paramString, int paramInt) {}
    
    public void ady(String paramString)
    {
      this.cWR = paramString;
    }
    
    public void afd(int paramInt)
    {
      this.stickerId = paramInt;
    }
    
    public void bd(boolean paramBoolean, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoAblumList", 2, "download Res Finished , type id, " + this.stickerId + " isSuccess : " + paramBoolean + " url : " + paramString + " StickerStr : " + this.cWR + " mParent : " + this.b);
      }
      if ((this.stickerId != -1) && (!TextUtils.isEmpty(this.cWR)) && (this.b != null)) {
        this.b.eJ(this.stickerId, this.cWR);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfc
 * JD-Core Version:    0.7.0.1
 */