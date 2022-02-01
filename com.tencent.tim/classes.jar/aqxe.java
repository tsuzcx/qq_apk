import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;
import java.util.Collections;

public class aqxe
  extends aqxb
{
  public aqxe(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    Collections.sort(this.this$0.mUins);
    this.this$0.cyu = this.this$0.mUins.toString();
    this.this$0.setProgessDialog(false, 0);
    this.this$0.cWL = paramBoolean;
    Object localObject1;
    int i;
    int j;
    String str;
    Object localObject2;
    Object localObject3;
    if (!paramBoolean)
    {
      localObject1 = (Bundle)paramObject;
      i = ((Bundle)localObject1).getInt("result");
      j = ((Bundle)localObject1).getInt("callId", this.this$0.eds);
      paramObject = ((Bundle)localObject1).getString("message");
      str = ((Bundle)localObject1).getString("svr_url");
      localObject2 = ((Bundle)localObject1).getString("svr_actStr");
      if (i != 9002) {
        break label290;
      }
      paramInt = 11;
      localObject3 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject3 = acfp.m(2131716772);
      }
      paramObject = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label607;
      }
      localObject1 = acfp.m(2131716750);
      localObject2 = null;
      paramInt = 11;
      paramObject = localObject3;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramObject)) {
        if ((i == 22001) || (i == 6002))
        {
          paramObject = acfp.m(2131716766);
          label222:
          VipFunCallPreviewActivity localVipFunCallPreviewActivity = this.this$0;
          localObject3 = localObject1;
          if (!TextUtils.isEmpty(str))
          {
            localObject3 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject3 = acfp.m(2131716770);
            }
          }
          localVipFunCallPreviewActivity.showTips(paramInt, j, null, paramObject, (String)localObject2, (String)localObject3, str);
          this.this$0.mUiHandler.sendEmptyMessage(50);
          return;
          label290:
          if (i == 9003)
          {
            paramInt = 12;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = acfp.m(2131716753);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = acfp.m(2131716765);
            localObject2 = null;
            paramInt = 12;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005011) || (i == 5002))
          {
            paramInt = 2;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = acfp.m(2131716759);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = acfp.m(2131716763);
            localObject2 = null;
            paramInt = 2;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if ((i == 1005012) || (i == 4002))
          {
            paramInt = 1;
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = acfp.m(2131716768);
            }
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label607;
            }
            localObject3 = acfp.m(2131716760);
            localObject2 = null;
            paramInt = 1;
            paramObject = localObject1;
            localObject1 = localObject3;
            continue;
          }
          if (i == 461001)
          {
            localObject1 = acfp.m(2131716775);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label601;
            }
          }
        }
      }
      label601:
      for (paramObject = acfp.m(2131716769);; paramObject = localObject2)
      {
        localObject3 = acfp.m(2131716758);
        str = aqqj.getUrl("funCallMine");
        paramInt = 6;
        localObject2 = localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject3;
        break;
        localObject3 = null;
        localObject1 = localObject2;
        paramInt = 4;
        localObject2 = localObject3;
        break;
        if (i == 3002)
        {
          paramObject = acfp.m(2131716749);
          break label222;
        }
        if (i == 8002)
        {
          paramObject = acfp.m(2131716776);
          break label222;
        }
        break label222;
      }
      label607:
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxe
 * JD-Core Version:    0.7.0.1
 */