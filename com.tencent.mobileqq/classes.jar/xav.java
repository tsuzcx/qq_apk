import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPermission.1;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xav
  extends xal
  implements xaw
{
  private int jdField_a_of_type_Int = 10000;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RedDotImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new EditVideoPermission.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10000;
  private boolean jdField_b_of_type_Boolean;
  
  public xav(@NonNull xan paramxan)
  {
    super(paramxan);
  }
  
  private int a()
  {
    int i = ((Integer)((uvt)uwa.a(10)).b("key_last_used_permission", Integer.valueOf(10000))).intValue();
    wxe.a("Q.qqstory.publish.edit.EditVideoPermission", "get default permission from local. type is %d.", Integer.valueOf(i));
    return i;
  }
  
  @NonNull
  private List<Long> a(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        wxe.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      wxj.a("pub_control", "clk_change", 0, 0, new String[] { String.valueOf(paramInt) });
      return;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  private void b(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      wxe.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown type:%s", new Object[] { Integer.valueOf(paramInt) });
      paramInt = 1;
      switch (this.jdField_a_of_type_Xan.a.b())
      {
      case 2: 
      default: 
        wxe.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown entrance:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xan.a.b()) });
        i = 99;
      }
      break;
    }
    for (;;)
    {
      wxe.a("Q.qqstory.publish.edit.EditVideoPermission", "report select permission, permissionType:%s, entranceType:%s", Integer.valueOf(paramInt), Integer.valueOf(i));
      wxj.a("pub_control", "clk_done", 0, 0, new String[] { String.valueOf(i), String.valueOf(paramInt) });
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      paramInt = 4;
      break;
      paramInt = 5;
      break;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  private void f()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, PermissionSettingActivity.class);
      localIntent.putExtra("PERMISSION_TYPE_KEY", this.jdField_b_of_type_Int);
      localIntent.putStringArrayListExtra("PERMISSION_UIN_LIST_KEY", this.jdField_a_of_type_JavaUtilArrayList);
      localActivity.startActivityForResult(localIntent, 1);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private void g()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131699900));
      return;
    case 10004: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131699908));
      return;
    case 10000: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131699900));
      return;
    case 10001: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131699904));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131699909));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131371709));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)a(2131371717));
    this.jdField_a_of_type_Int = a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    g();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(8);
    a(xaw.class, this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    String str;
    Object localObject;
    if (paramInt1 == 1) {
      if ((paramInt2 == 1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("PERMISSION_TYPE_KEY", -2147483648);
        str = paramIntent.getStringExtra("PERMISSION_CURRENT_UIN_KEY");
        localObject = null;
        switch (paramInt1)
        {
        }
      }
    }
    for (paramIntent = localObject;; paramIntent = paramIntent.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY"))
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramIntent != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramIntent);
      }
      b(paramInt1);
      g();
      this.jdField_a_of_type_Xan.a(0);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = i;; paramInt = 2)
    {
      wxj.a("pub_control", "clk_entry", 0, 0, new String[] { String.valueOf(paramInt) });
      f();
      return;
    }
  }
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    super.a(paramInt, paramxlb);
    wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "EditVideoPermission editVideoPrePublish....");
    Object localObject = new ArrayList();
    int i;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      i = 0;
    }
    try
    {
      for (;;)
      {
        long l = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        if (((List)localObject).contains(Long.valueOf(l))) {
          ((List)localObject).remove(Long.valueOf(l));
        }
        wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "permissionType:" + i);
        wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "permissionUinList:" + localObject.toString());
        qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
        localVideoReaderConf.ban_type.set(i);
        localVideoReaderConf.user_list.set((List)localObject);
        localVideoReaderConf.setHasFlag(true);
        paramxlb.a.readerConfBytes = localVideoReaderConf.toByteArray();
        if ((paramInt == 0) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int))
        {
          wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "user has changed permission during editing session. default permission is %d, new permission is %d.", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int));
          a(this.jdField_b_of_type_Int);
        }
        return;
        i = 1000;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        localObject = a(this.jdField_a_of_type_JavaUtilArrayList);
        continue;
        i = 3;
        localObject = a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        wxe.e("Q.qqstory.publish.edit.EditVideoPermission", "MyUin , can't format uin:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      }
    }
  }
  
  public void ac_()
  {
    wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "onStop, set jump flag false.");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.ac_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xav
 * JD-Core Version:    0.7.0.1
 */