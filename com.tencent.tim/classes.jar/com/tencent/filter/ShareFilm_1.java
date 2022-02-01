package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;

public class ShareFilm_1
  extends BaseFilter
{
  public ShareFilm_1()
  {
    super(BaseFilter.getFragmentShader(5), "share_film.jpg");
    addParam(new UniformParam.Float2fParam("randomCoord2", (float)Math.random(), (float)Math.random()));
  }
  
  public void OnDrawFrameGLSL()
  {
    UniformParam.Float2fParam localFloat2fParam = (UniformParam.Float2fParam)getParam("randomCoord2");
    localFloat2fParam.x = ((float)Math.random());
    localFloat2fParam.y = ((float)Math.random());
    super.OnDrawFrameGLSL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.ShareFilm_1
 * JD-Core Version:    0.7.0.1
 */