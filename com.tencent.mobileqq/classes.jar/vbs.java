import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class vbs
  extends vbk
{
  public vbs(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = alud.a(2131713648);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131373850, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, uyg paramuyg)
  {
    if ((!TextUtils.isEmpty(paramuyg.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramuyg.j);
      return;
    }
    super.a(paramString, paramBoolean, paramuyg);
  }
  
  public void a(uyg paramuyg)
  {
    super.a(paramuyg);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131373850), paramuyg.jdField_a_of_type_JavaLangString))
    {
      if ((paramuyg.jdField_a_of_type_JavaUtilList == null) || (paramuyg.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((uyy)paramuyg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramuyg.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        uyy localuyy = (uyy)localIterator.next();
        if (!localuyy.jdField_a_of_type_Boolean) {
          str = localuyy.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      wxj.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramuyg.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131373850, paramuyg.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbs
 * JD-Core Version:    0.7.0.1
 */