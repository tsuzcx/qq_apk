import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class wyz
  extends wyr
{
  public wyz(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = anzj.a(2131712136);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131374689, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, wvn paramwvn)
  {
    if ((!TextUtils.isEmpty(paramwvn.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramwvn.j);
      return;
    }
    super.a(paramString, paramBoolean, paramwvn);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131374689), paramwvn.jdField_a_of_type_JavaLangString))
    {
      if ((paramwvn.jdField_a_of_type_JavaUtilList == null) || (paramwvn.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((wwf)paramwvn.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramwvn.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wwf localwwf = (wwf)localIterator.next();
        if (!localwwf.jdField_a_of_type_Boolean) {
          str = localwwf.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      yup.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramwvn.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131374689, paramwvn.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyz
 * JD-Core Version:    0.7.0.1
 */