import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.search.util.SearchConfigManager;

class amsg
  implements View.OnLongClickListener
{
  amsg(amsf paramamsf, ampx paramampx) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new AlertDialog.Builder(paramView.getContext());
    paramView.setTitle(acfp.m(2131704465));
    long l = ((ampt)this.jdField_a_of_type_Ampx).gN();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = SearchConfigManager.contactSearchPinyinBaseBit;
    int j = SearchConfigManager.contactSearchPinyinBaseBit;
    localStringBuilder.append("拼音匹配：");
    localStringBuilder.append((9223372036854775807L << i & l) >> j);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchRecentBaseBit;
    j = SearchConfigManager.contactSearchRecentBaseBit;
    int k = SearchConfigManager.contactSearchRecentBaseBit;
    localStringBuilder.append("最近联系人排序：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 10) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchIndexBaseBit;
    j = SearchConfigManager.contactSearchIndexBaseBit;
    k = SearchConfigManager.contactSearchIndexBaseBit;
    localStringBuilder.append("字符串匹配度：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 8) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchTypeBaseBit;
    j = SearchConfigManager.contactSearchTypeBaseBit;
    k = SearchConfigManager.contactSearchTypeBaseBit;
    localStringBuilder.append("数据类型：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 8) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.contactSearchFieldBaseBit;
    localStringBuilder.append("字段类型：");
    localStringBuilder.append((l & 9223372036854775807L >> 63 - (i + 8) & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    paramView.setMessage(localStringBuilder.toString());
    paramView.create().show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsg
 * JD-Core Version:    0.7.0.1
 */