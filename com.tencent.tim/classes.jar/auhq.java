import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;

public class auhq
  extends augz
  implements auhk.i
{
  public auhq(QQAppInterface paramQQAppInterface, Context paramContext, auhk.d paramd)
  {
    super(paramQQAppInterface, paramContext, paramd);
  }
  
  public void a(byte[] paramArrayOfByte1, FileInfo paramFileInfo, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte1, List<FileInfo> paramList, byte[] paramArrayOfByte2) {}
  
  public void al(Object... paramVarArgs)
  {
    this.a.a(this.context, paramVarArgs);
  }
  
  public void bG(Object paramObject) {}
  
  public void bH(Object paramObject) {}
  
  public void c(atkw paramatkw)
  {
    paramatkw.fZ(this.context);
  }
  
  public void d(atkw paramatkw)
  {
    if (!(this.context instanceof Activity)) {}
    do
    {
      do
      {
        return;
      } while (paramatkw.relatedType != 7);
      paramatkw = (PadInfo)paramatkw.fQ;
    } while ((paramatkw == null) || (TextUtils.isEmpty(paramatkw.pad_url)));
    int i = paramatkw.type_list;
    String str1 = paramatkw.pad_url;
    String str2 = paramatkw.title;
    String str3 = String.valueOf(paramatkw.creatorUin);
    Intent localIntent = new Intent(this.context, TeamWorkTransparentShareActivity.class);
    if ((!TextUtils.isEmpty(str3)) && (str3.equals(this.app.getCurrentAccountUin()))) {
      localIntent.putExtra("team_is_my_document", true);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra(aoaf.cjn, str2);
    }
    if (!TextUtils.isEmpty(str1)) {
      localIntent.putExtra("team_work_pad_url", str1);
    }
    localIntent.putExtra("team_policy", paramatkw.policy);
    localIntent.putExtra("team_work_pad_list_type", paramatkw.type_list);
    localIntent.putExtra("team_work_pad_type", paramatkw.type);
    localIntent.putExtra("from_activity", this.context.getClass().getSimpleName());
    localIntent.putExtra("select_type", i);
    ((Activity)this.context).overridePendingTransition(0, 0);
    this.context.startActivity(localIntent);
  }
  
  public void k(Object paramObject, String paramString) {}
  
  public void nS(List<Object> paramList) {}
  
  public void nT(List<Object> paramList) {}
  
  public void o(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhq
 * JD-Core Version:    0.7.0.1
 */