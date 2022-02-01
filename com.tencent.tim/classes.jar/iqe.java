import com.tencent.av.opengl.program.TextureProgram;

public class iqe
  extends TextureProgram
{
  public iqe()
  {
    super("uniform  mat4   uMatrix;\nuniform  mat4 uTextureMatrix;\nattribute vec2  aPosition ;\nvarying vec2 vTextureCoord;\nvoid main(void)\n{\nvec4 pos = vec4(aPosition, 0.0, 1.0);\n gl_Position = uMatrix * pos;\n vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTextureSampler0;\nconst mat3 m = mat3(0.2990, 0.5870, 0.1140,-0.1687,-0.3313, 0.5,0.5,-0.4187,-0.0813);\nconst vec3 adduv = vec3(0.0,0.5,0.5);\nvoid main(void)\n{\nvec4 color = texture2D(uTextureSampler0, vTextureCoord);\nvec3 rgb =  color.rgb * m + adduv;\ngl_FragColor =vec4(rgb,1.0);\n}\n", new iqi[] { new iqh("aPosition"), new iqj("uMatrix"), new iqj("uAlpha"), new iqj("uTextureMatrix"), new iqj("uTextureSampler0") }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqe
 * JD-Core Version:    0.7.0.1
 */