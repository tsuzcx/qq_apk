import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

public final class lw
{
  private ErrorCorrectionLevel jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  private Mode jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode;
  private lp jdField_a_of_type_Lp;
  private lr jdField_a_of_type_Lr;
  private int iY = -1;
  
  public static boolean z(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public void S(int paramInt)
  {
    this.iY = paramInt;
  }
  
  public lr a()
  {
    return this.jdField_a_of_type_Lr;
  }
  
  public void a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel = paramErrorCorrectionLevel;
  }
  
  public void a(Mode paramMode)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode = paramMode;
  }
  
  public void a(lp paramlp)
  {
    this.jdField_a_of_type_Lp = paramlp;
  }
  
  public void e(lr paramlr)
  {
    this.jdField_a_of_type_Lr = paramlr;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.jdField_a_of_type_Lp);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.iY);
    if (this.jdField_a_of_type_Lr == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.jdField_a_of_type_Lr.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lw
 * JD-Core Version:    0.7.0.1
 */