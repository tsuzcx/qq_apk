import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.HashMap;
import org.json.JSONObject;

public class xuf
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private xug jdField_a_of_type_Xug;
  
  public xuf(Activity paramActivity, xug paramxug)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xug = paramxug;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("qq_number", -1L);
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("union_id");
    if (TextUtils.isEmpty(paramIntent))
    {
      QQStoryMemoriesActivity.a(paramActivity, i, l);
      return;
    }
    weg.a(paramActivity, i, paramIntent);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("union_id");
    int i = paramIntent.getIntExtra("source", 0);
    paramIntent = paramIntent.getStringExtra("extra_share_from_uid");
    localObject = QQStoryShareGroupProfileActivity.a(paramActivity, 2, (String)localObject, null, i, 0);
    ((Intent)localObject).putExtra("extra_share_from_user_uid", paramIntent);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("tag_id");
    paramIntent = paramIntent.getStringExtra("tag_type");
    if ((str == null) || (paramIntent == null))
    {
      ykq.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handleOpenTagAction parm error");
      return;
    }
    xab.a(paramActivity, str, paramIntent);
  }
  
  public static void d(Activity paramActivity, Intent paramIntent)
  {
    paramIntent = (String)((wjl)wjs.a(10)).b("mainHallConfig", "");
    if (!TextUtils.isEmpty(paramIntent)) {}
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject(paramIntent).optString("url");
        if (!TextUtils.isEmpty(paramIntent)) {
          break;
        }
        ykq.d("Q.qqstory.home.QQStoryHomeJumpHelper", "square config not ready , use default config instead");
        return;
      }
      catch (Exception paramIntent)
      {
        ykq.d("Q.qqstory.home.QQStoryHomeJumpHelper", "analyze config error , error :%s", new Object[] { paramIntent.getMessage() });
      }
      paramIntent = "";
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramIntent);
    paramActivity.startActivity(localIntent);
  }
  
  private void e(Intent paramIntent)
  {
    paramIntent = (HashMap)paramIntent.getSerializableExtra("extra_jump_attrs");
    String str = (String)paramIntent.get("parter_api");
    bheh.c(QQStoryContext.a(), this.jdField_a_of_type_AndroidAppActivity, paramIntent, str);
  }
  
  private void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    paramIntent.getLongExtra("extra_topic_id", -1L);
    paramIntent.getStringExtra("extra_topic_name");
    bheh.d(i + "");
  }
  
  private void g(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("extra_share_from_type", -1);
    bheh.d(i + "");
    if ("1".equals(paramIntent.getStringExtra("to_new_version"))) {}
  }
  
  private void h(Intent paramIntent)
  {
    paramIntent.getStringExtra("EXTRA_USER_UIN");
    String str = paramIntent.getStringExtra("EXTRA_USER_UNION_ID");
    paramIntent.getBooleanExtra("extra_is_show_info_card", false);
    paramIntent.getIntExtra("extra_share_from_type", 0);
    weg.a(this.jdField_a_of_type_AndroidAppActivity, 23, str);
  }
  
  private void i(Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("usertype", 0);
    String str = paramIntent.getStringExtra("unionid");
    paramIntent.getStringExtra("userid");
    paramIntent.getBooleanExtra("showinfocard", true);
    paramIntent.getIntExtra("storysharefrom", 0);
    if (i == 1) {
      weg.a(this.jdField_a_of_type_AndroidAppActivity, 23, str);
    }
  }
  
  public boolean a(int paramInt, Intent paramIntent)
  {
    ykq.b("Q.qqstory.home.QQStoryHomeJumpHelper", "handleAction=" + paramInt);
    switch (paramInt)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidAppActivity.setIntent(paramIntent);
      this.jdField_a_of_type_Xug.a(false, true, 16, null);
      return true;
    case 2: 
      a(paramIntent);
      return true;
    case 5: 
      e(paramIntent);
      return true;
    case 4: 
      f(paramIntent);
      return true;
    case 12: 
      g(paramIntent);
      return true;
    case 7: 
      h(paramIntent);
      return true;
    case 6: 
      i(paramIntent);
      return true;
    case 8: 
      b(paramIntent);
      return true;
    case 9: 
      c(paramIntent);
      return true;
    case 10: 
      d(paramIntent);
      return true;
    case 11: 
      a(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
      return true;
    case 13: 
      b(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
      return true;
    case 14: 
      c(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
      return true;
    }
    d(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
    return true;
  }
  
  protected void b(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, StoryMessageListActivity.class);
    if (((wms)QQStoryContext.a().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a) {
      paramIntent.putExtra("qqstory_message_list_source", 2);
    }
    localIntent.replaceExtras(paramIntent.getExtras());
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  protected void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("EXTRA_PLAY_INFO");
    if (paramIntent == null)
    {
      ykq.e("Q.qqstory.home.QQStoryHomeJumpHelper", "handle open play list error , no play info !");
      return;
    }
    xbp.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, 31, null);
  }
  
  protected void d(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.replaceExtras(paramIntent.getExtras());
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuf
 * JD-Core Version:    0.7.0.1
 */