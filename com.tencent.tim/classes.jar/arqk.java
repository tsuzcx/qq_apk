import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.open.agent.CreateVirtualAccountFragment;

public class arqk
  implements InputFilter
{
  public arqk(CreateVirtualAccountFragment paramCreateVirtualAccountFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = 12 - (paramSpanned.length() - (paramInt4 - paramInt3));
    if (paramInt3 <= 0)
    {
      CreateVirtualAccountFragment.a(this.this$0, "昵称最多可输入12个字", false);
      return "";
    }
    if (paramInt3 >= paramInt2 - paramInt1) {
      return null;
    }
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1)
      {
        CreateVirtualAccountFragment.a(this.this$0, "昵称最多可输入12个字", false);
        return "";
      }
    }
    CreateVirtualAccountFragment.a(this.this$0, "昵称最多可输入12个字", false);
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */