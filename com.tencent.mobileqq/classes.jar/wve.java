import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class wve
  extends wuw
{
  public wve(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = anni.a(2131712027);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131374552, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, wrs paramwrs)
  {
    if ((!TextUtils.isEmpty(paramwrs.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramwrs.j);
      return;
    }
    super.a(paramString, paramBoolean, paramwrs);
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131374552), paramwrs.jdField_a_of_type_JavaLangString))
    {
      if ((paramwrs.jdField_a_of_type_JavaUtilList == null) || (paramwrs.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((wsk)paramwrs.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramwrs.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wsk localwsk = (wsk)localIterator.next();
        if (!localwsk.jdField_a_of_type_Boolean) {
          str = localwsk.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      yqu.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwrs.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131374552, paramwrs.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wve
 * JD-Core Version:    0.7.0.1
 */