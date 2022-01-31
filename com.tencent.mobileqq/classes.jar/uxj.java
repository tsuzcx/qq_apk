import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class uxj
  extends uxb
{
  public uxj(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = alpo.a(2131713636);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131373799, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, utx paramutx)
  {
    if ((!TextUtils.isEmpty(paramutx.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramutx.j);
      return;
    }
    super.a(paramString, paramBoolean, paramutx);
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131373799), paramutx.jdField_a_of_type_JavaLangString))
    {
      if ((paramutx.jdField_a_of_type_JavaUtilList == null) || (paramutx.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((uup)paramutx.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramutx.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        uup localuup = (uup)localIterator.next();
        if (!localuup.jdField_a_of_type_Boolean) {
          str = localuup.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      wta.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramutx.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131373799, paramutx.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxj
 * JD-Core Version:    0.7.0.1
 */