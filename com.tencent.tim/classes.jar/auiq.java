import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;

public class auiq
  extends augz
  implements auhk.j
{
  public auiq(QQAppInterface paramQQAppInterface, Context paramContext, auhk.d paramd)
  {
    super(paramQQAppInterface, paramContext, paramd);
  }
  
  public void a(byte[] paramArrayOfByte1, FileInfo paramFileInfo, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte1, List<FileInfo> paramList, byte[] paramArrayOfByte2) {}
  
  public void al(Object... paramVarArgs)
  {
    this.a.a(this.context, paramVarArgs);
  }
  
  public void b(PadInfo paramPadInfo)
  {
    if (!(this.context instanceof Activity)) {}
    while ((paramPadInfo == null) || (TextUtils.isEmpty(paramPadInfo.pad_url))) {
      return;
    }
    String str1 = paramPadInfo.pad_url;
    String str2 = paramPadInfo.title;
    String str3 = String.valueOf(paramPadInfo.creatorUin);
    Intent localIntent = new Intent(this.context, TeamWorkTransparentShareActivity.class);
    if ((!TextUtils.isEmpty(str3)) && (str3.equals(this.app.getCurrentAccountUin()))) {
      localIntent.putExtra("team_is_my_document", true);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra(auko.cjn, str2);
    }
    if (!TextUtils.isEmpty(str1)) {
      localIntent.putExtra("team_work_pad_url", str1);
    }
    localIntent.putExtra("team_policy", paramPadInfo.policy);
    localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
    localIntent.putExtra("team_work_pad_type", paramPadInfo.type);
    localIntent.putExtra("from_activity", this.context.getClass().getSimpleName());
    ((Activity)this.context).overridePendingTransition(0, 0);
    this.context.startActivity(localIntent);
  }
  
  public void bG(Object paramObject)
  {
    this.a.e(this.context, paramObject);
  }
  
  public void bH(Object paramObject)
  {
    this.a.d(this.context, paramObject);
  }
  
  public void k(Object paramObject, String paramString) {}
  
  public void nT(List<Object> paramList)
  {
    this.a.h(this.context, paramList);
  }
  
  public void o(int paramInt, Object... paramVarArgs)
  {
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.a != null))
    {
      this.a.qw(BaseApplicationImpl.getContext().getString(2131693404));
      return;
    }
    aulh localaulh = (aulh)this.app.getBusinessHandler(122);
    paramInt = 0;
    label51:
    PadInfo localPadInfo;
    int i;
    if (paramInt < paramVarArgs.length)
    {
      localPadInfo = (PadInfo)paramVarArgs[paramInt];
      if ((localPadInfo != null) && (!TextUtils.isEmpty(localPadInfo.pad_url)))
      {
        i = localPadInfo.type_list;
        if (i != 2) {
          break label153;
        }
        if ((localPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(localPadInfo.creatorUin)))) {
          break label140;
        }
        localaulh.Zq(localPadInfo.pad_url);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label51;
      break;
      label140:
      localaulh.Zr(localPadInfo.pad_url);
      continue;
      label153:
      if (i == 1) {
        localaulh.Zq(localPadInfo.pad_url);
      } else if (i == 3) {
        localaulh.Zs(localPadInfo.pad_url);
      } else if (i == 4) {
        localaulh.Zp(localPadInfo.pad_url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auiq
 * JD-Core Version:    0.7.0.1
 */