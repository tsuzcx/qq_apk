import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class wpk
  extends wpc
{
  public wpk(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = anvx.a(2131712715);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131374695, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, wly paramwly)
  {
    if ((!TextUtils.isEmpty(paramwly.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramwly.j);
      return;
    }
    super.a(paramString, paramBoolean, paramwly);
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131374695), paramwly.jdField_a_of_type_JavaLangString))
    {
      if ((paramwly.jdField_a_of_type_JavaUtilList == null) || (paramwly.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((wmq)paramwly.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramwly.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wmq localwmq = (wmq)localIterator.next();
        if (!localwmq.jdField_a_of_type_Boolean) {
          str = localwmq.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      ykv.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwly.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131374695, paramwly.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpk
 * JD-Core Version:    0.7.0.1
 */