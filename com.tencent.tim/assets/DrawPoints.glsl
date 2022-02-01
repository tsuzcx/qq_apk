precision highp float;
varying vec2 textureCoordinate;
uniform sampler2D inputImageTexture;
uniform float facePoints[196];
uniform vec2 canvasSize;
uniform vec2 faceDetectImageSize;

void main(void) {
  vec4 texColor = texture2D(inputImageTexture, textureCoordinate);

    vec2 canvasCoord = vec2(textureCoordinate.x * canvasSize.x, textureCoordinate.y * canvasSize.y);
    for (int i = 0; i < 98; ++i) {
      float x = facePoints[i*2+0] * canvasSize.x / faceDetectImageSize.x;
      float y = facePoints[i*2+1] * canvasSize.y / faceDetectImageSize.y;
      vec2 p = vec2(x, y);
      float dis = distance(canvasCoord, p);
      if (dis <= 3.0) {
        if(i == 92 || i == 95){
            texColor = mix(texColor, vec4(0.0, 0.0, 1.0, 1.0), 0.5);
            break;
        }

        if(i < 92){
            texColor = mix(texColor, vec4(1.0, 0.0, 0.0, 1.0), 0.5);
            break;
        } else{
            texColor = mix(texColor, vec4(0.0, 1.0, 0.0, 1.0), 0.5);
            break;
        }
      }
    }

  gl_FragColor = texColor;
}