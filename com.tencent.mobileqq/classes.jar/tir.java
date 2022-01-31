import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.Iterator;
import java.util.List;

public class tir
  extends tij
{
  public tir(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = ajya.a(2131713264);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131373350, null);
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, tff paramtff)
  {
    if ((!TextUtils.isEmpty(paramtff.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramtff.j);
      return;
    }
    super.a(paramString, paramBoolean, paramtff);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131373350), paramtff.jdField_a_of_type_JavaLangString))
    {
      if ((paramtff.jdField_a_of_type_JavaUtilList == null) || (paramtff.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((tfx)paramtff.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramtff.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        tfx localtfx = (tfx)localIterator.next();
        if (!localtfx.jdField_a_of_type_Boolean) {
          str = localtfx.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      vei.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramtff.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131373350, paramtff.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tir
 * JD-Core Version:    0.7.0.1
 */