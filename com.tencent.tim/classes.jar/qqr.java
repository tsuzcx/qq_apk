import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import org.json.JSONObject;

public class qqr
{
  private qqr.a a;
  private Activity z;
  
  public qqr(Activity paramActivity, qqr.a parama)
  {
    this.z = paramActivity;
    this.a = parama;
  }
  
  private void ba(Intent paramIntent)
  {
    paramIntent = (HashMap)paramIntent.getSerializableExtra("extra_jump_attrs");
    String str = (String)paramIntent.get("parter_api");
    aqhv.a(QQStoryContext.a(), this.z, paramIntent, str);
  }
  
  private void bb(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    paramIntent.getLongExtra("extra_topic_id", -1L);
    paramIntent.getStringExtra("extra_topic_name");
    aqhv.jE(i + "");
  }
  
  private void bc(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    aqhv.jE(i + "");
    if ("1".equals(paramIntent.getStringExtra("to_new_version"))) {}
  }
  
  private void bd(Intent paramIntent)
  {
    paramIntent.getStringExtra("EXTRA_USER_UIN");
    String str = paramIntent.getStringExtra("EXTRA_USER_UNION_ID");
    paramIntent.getBooleanExtra("extra_is_show_info_card", false);
    paramIntent.getIntExtra("extra_share_from_type", 0);
    ppf.f(this.z, 23, str);
  }
  
  private void be(Intent paramIntent) {}
  
  public static void t(Activity paramActivity, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("qq_number", -1L);
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("union_id");
    if (TextUtils.isEmpty(paramIntent))
    {
      QQStoryMemoriesActivity.c(paramActivity, i, l);
      return;
    }
    ppf.f(paramActivity, i, paramIntent);
  }
  
  public static void u(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("union_id");
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("extra_share_from_uid");
    localObject = QQStoryShareGroupProfileActivity.a(paramActivity, 2, (String)localObject, null, i, 0);
    ((Intent)localObject).putExtra("extra_share_from_user_uid", paramIntent);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void v(Activity paramActivity, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("tag_id");
    paramIntent = paramIntent.getStringExtra("tag_type");
    if ((str == null) || (paramIntent == null))
    {
      ram.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handleOpenTagAction parm error");
      return;
    }
    qev.d(paramActivity, str, paramIntent);
  }
  
  public static void w(Activity paramActivity, Intent paramIntent)
  {
    paramIntent = (String)((psr)psx.a(10)).c("mainHallConfig", "");
    if (!TextUtils.isEmpty(paramIntent)) {}
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject(paramIntent).optString("url");
        if (!TextUtils.isEmpty(paramIntent)) {
          break;
        }
        ram.w("Q.qqstory.home.QQStoryHomeJumpHelper", "square config not ready , use default config instead");
        return;
      }
      catch (Exception paramIntent)
      {
        ram.w("Q.qqstory.home.QQStoryHomeJumpHelper", "analyze config error , error :%s", new Object[] { paramIntent.getMessage() });
      }
      paramIntent = "";
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public void aZ(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("usertype", 0);
    String str = paramIntent.getStringExtra("unionid");
    paramIntent.getStringExtra("userid");
    paramIntent.getBooleanExtra("showinfocard", true);
    paramIntent.getIntExtra("storysharefrom", 0);
    if (i == 1) {
      ppf.f(this.z, 23, str);
    }
  }
  
  public boolean b(int paramInt, Intent paramIntent)
  {
    ram.d("Q.qqstory.home.QQStoryHomeJumpHelper", "handleAction=" + paramInt);
    switch (paramInt)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      this.z.setIntent(paramIntent);
      this.a.b(false, true, 16, null);
      return true;
    case 2: 
      aZ(paramIntent);
      return true;
    case 5: 
      ba(paramIntent);
      return true;
    case 4: 
      bb(paramIntent);
      return true;
    case 12: 
      bc(paramIntent);
      return true;
    case 7: 
      bd(paramIntent);
      return true;
    case 6: 
      be(paramIntent);
      return true;
    case 8: 
      bf(paramIntent);
      return true;
    case 9: 
      bg(paramIntent);
      return true;
    case 10: 
      bh(paramIntent);
      return true;
    case 11: 
      t(this.z, paramIntent);
      return true;
    case 13: 
      u(this.z, paramIntent);
      return true;
    case 14: 
      v(this.z, paramIntent);
      return true;
    }
    w(this.z, paramIntent);
    return true;
  }
  
  protected void bf(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.z, StoryMessageListActivity.class);
    if (((puz)QQStoryContext.a().getManager(252)).aBT) {
      paramIntent.putExtra("qqstory_message_list_source", 2);
    }
    localIntent.replaceExtras(paramIntent.getExtras());
    this.z.startActivity(localIntent);
  }
  
  protected void bg(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("EXTRA_PLAY_INFO");
    if (paramIntent == null)
    {
      ram.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handle open play list error , no play info !");
      return;
    }
    qgg.a(this.z, paramIntent, 31, null);
  }
  
  protected void bh(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.z, QQBrowserActivity.class);
    localIntent.replaceExtras(paramIntent.getExtras());
    this.z.startActivity(localIntent);
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqr
 * JD-Core Version:    0.7.0.1
 */