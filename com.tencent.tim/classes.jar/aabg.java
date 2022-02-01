import android.text.Editable;
import android.util.SparseArray;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.IdiomHbBundleInfo;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.a;
import java.util.List;

public class aabg
  implements WordChainHbFragment.a
{
  public aabg(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void G(boolean paramBoolean, List<String> paramList)
  {
    paramList = WordChainHbFragment.a(this.this$0, true);
    this.this$0.aW.setText(paramList);
    WordChainHbFragment.a(this.this$0).put(WordChainHbFragment.a(this.this$0).currSelectedSubChannel, paramList);
    this.this$0.aW.setSelection(this.this$0.aW.getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabg
 * JD-Core Version:    0.7.0.1
 */