import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ipg
{
  private final String FRAG_SHADER = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
  public final String PH = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
  private String PI = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
  private String PJ = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
  private float[] U = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float[] V = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  protected int arF;
  protected int arG;
  protected int arH;
  protected int arI;
  protected int arJ;
  protected int arK;
  private int arL;
  private int arM;
  protected int mHeight;
  protected FloatBuffer mTextureBuffer;
  protected FloatBuffer mVertexBuffer;
  protected int mWidth;
  
  public ipg()
  {
    api();
  }
  
  public static int f(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        f(1, "Could not link program:" + GLES20.glGetProgramInfoLog(k));
        GLES20.glDeleteProgram(k);
        return 0;
      }
    }
    return k;
  }
  
  private static void f(int paramInt, Object paramObject)
  {
    QLog.e("TAG", 1, "glError:" + paramInt + "---" + paramObject);
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      f(1, "Shader source ==null : shaderType =" + paramInt);
      return 0;
    }
    int i = GLES20.glCreateShader(paramInt);
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        f(1, "Could not compile shader:" + paramInt);
        f(1, "GLES20 Error:" + GLES20.glGetShaderInfoLog(i));
        GLES20.glDeleteShader(i);
        return 0;
      }
    }
    return i;
  }
  
  protected void api()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F });
    this.mVertexBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mTextureBuffer = localByteBuffer.asFloatBuffer();
    this.mTextureBuffer.put(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    this.mTextureBuffer.position(0);
  }
  
  protected void apj()
  {
    GLES20.glUseProgram(this.arF);
  }
  
  protected void apk()
  {
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16640);
  }
  
  protected void apl()
  {
    GLES20.glUniformMatrix4fv(this.arI, 1, false, this.V, 0);
    GLES20.glUniformMatrix4fv(this.arJ, 1, false, this.U, 0);
    GLES20.glUniform1f(this.arL, this.mWidth);
    GLES20.glUniform1f(this.arM, this.mHeight);
  }
  
  public void bG(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void destroy()
  {
    GLES20.glDeleteProgram(this.arF);
  }
  
  public void draw(int paramInt)
  {
    apk();
    apj();
    apl();
    lp(paramInt);
    onDraw();
  }
  
  protected void lp(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glUniform1i(this.arK, 0);
  }
  
  protected void onCreate()
  {
    this.arF = f(this.PI, this.PJ);
    this.arG = GLES20.glGetAttribLocation(this.arF, "aVertexCo");
    this.arH = GLES20.glGetAttribLocation(this.arF, "aTextureCo");
    this.arI = GLES20.glGetUniformLocation(this.arF, "uVertexMatrix");
    this.arJ = GLES20.glGetUniformLocation(this.arF, "uTextureMatrix");
    this.arK = GLES20.glGetUniformLocation(this.arF, "uTexture");
    this.arL = GLES20.glGetUniformLocation(this.arF, "uWidth");
    this.arM = GLES20.glGetUniformLocation(this.arF, "uHeight");
  }
  
  protected void onDraw()
  {
    GLES20.glEnableVertexAttribArray(this.arG);
    GLES20.glVertexAttribPointer(this.arG, 2, 5126, false, 0, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(this.arH);
    GLES20.glVertexAttribPointer(this.arH, 2, 5126, false, 0, this.mTextureBuffer);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.arG);
    GLES20.glDisableVertexAttribArray(this.arH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipg
 * JD-Core Version:    0.7.0.1
 */