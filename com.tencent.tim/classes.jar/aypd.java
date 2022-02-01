import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class aypd
  extends aypc
{
  private View Nq;
  private rsr a;
  private String cXK = "";
  protected boolean dAi;
  
  public void a(Context paramContext, aypc.b paramb, EditText paramEditText, TextView paramTextView, aypc.a parama)
  {
    super.a(paramContext, paramb, paramEditText, paramTextView, parama);
    this.jdField_a_of_type_Rsr = new rsr(paramContext);
    this.jdField_a_of_type_Rsr.setRatable(false);
    this.jdField_a_of_type_Rsr.setRate(0.0F);
    this.jdField_a_of_type_Rsr.uj(true);
    this.Nq = this.jdField_a_of_type_Rsr.az();
    if (paramb == null) {
      b(this.jdField_a_of_type_Rsr.getHint(), true);
    }
    for (;;)
    {
      d(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Rsr.t(paramb.jn);
      b(paramb.jn[0], false);
    }
  }
  
  public aypc.b b()
  {
    return new aypc.b(this.jdField_a_of_type_Rsr.aa(), this.jdField_a_of_type_Rsr.C(), this.jdField_a_of_type_Rsr.a(), this.dAi);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cXK = null;
    if (this.jdField_a_of_type_Rsr != null)
    {
      paramCharSequence = this.jdField_a_of_type_Rsr.C();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.cXK = paramCharSequence[0];
      }
    }
  }
  
  protected View cO()
  {
    return this.Nq;
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_Rsr.t(new String[] { this.editText.getText().toString() });
    this.jdField_a_of_type_Rsr.uj(false);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Rsr.t(new String[] { this.editText.getText().toString() });
      this.jdField_a_of_type_Rsr.uj(false);
      this.jdField_a_of_type_Aypc$a.eTg();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = aqmr.getWordCountNeo(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = aqmr.substringNeo(paramCharSequence.toString(), 0, 24);
        paramInt1 = aqmr.getWordCountNeo(((CharSequence)localObject).toString());
        b((CharSequence)localObject, false);
      }
      this.hintText.setVisibility(0);
      this.hintText.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Rsr.t(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        b(this.jdField_a_of_type_Rsr.getHint(), true);
      }
      if ((this.cXK != null) && (!paramCharSequence.toString().equals(this.cXK))) {
        this.dAi = true;
      }
      return;
      this.hintText.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypd
 * JD-Core Version:    0.7.0.1
 */