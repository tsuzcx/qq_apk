import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class wap
  extends wah
{
  public wap(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = amtj.a(2131712368);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131374457, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, vxd paramvxd)
  {
    if ((!TextUtils.isEmpty(paramvxd.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramvxd.j);
      return;
    }
    super.a(paramString, paramBoolean, paramvxd);
  }
  
  public void a(vxd paramvxd)
  {
    super.a(paramvxd);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131374457), paramvxd.jdField_a_of_type_JavaLangString))
    {
      if ((paramvxd.jdField_a_of_type_JavaUtilList == null) || (paramvxd.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((vxv)paramvxd.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramvxd.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        vxv localvxv = (vxv)localIterator.next();
        if (!localvxv.jdField_a_of_type_Boolean) {
          str = localvxv.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      xwa.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramvxd.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131374457, paramvxd.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wap
 * JD-Core Version:    0.7.0.1
 */