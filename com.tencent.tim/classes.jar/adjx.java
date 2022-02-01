import android.opengl.GLES20;

public class adjx
  extends adkd
{
  public int cHJ;
  public int cHK;
  
  public adjx(int paramInt)
  {
    super(paramInt);
    this.btA = "uniform float uA;\nuniform float uD;\n";
    this.btF = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
  }
  
  protected void a(adkf paramadkf)
  {
    if (paramadkf == null) {
      return;
    }
    GLES20.glUniform1f(this.cHJ, paramadkf.uY);
    GLES20.glUniform1f(this.cHK, paramadkf.uZ);
  }
  
  protected void cSi()
  {
    this.cHJ = GLES20.glGetUniformLocation(this.mProgramId, "uA");
    adkg.checkGlError("glGetAttribLocation uA");
    this.cHK = GLES20.glGetUniformLocation(this.mProgramId, "uD");
    adkg.checkGlError("glGetAttribLocation uD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjx
 * JD-Core Version:    0.7.0.1
 */