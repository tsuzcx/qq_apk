//#extension GL_OES_EGL_image_external : require
//precision mediump float;       	// Set the default precision to medium. We don't need as high of a
								// precision in the fragment shader.
//uniform vec3 u_LightPos;       	// The position of the light in eye space.
//uniform samplerExternalOES u_Texture;
  
//varying vec3 v_Position;		// Interpolated position for this fragment.
//varying vec4 v_Color;          	// This is the color from the vertex shader interpolated across the
  								// triangle per fragment.
//varying vec3 v_Normal;         	// Interpolated normal for this fragment.
//varying vec2 v_TexCoordinate;   // Interpolated texture coordinate per fragment.
  
// The entry point for our fragment shader.
//void main()
//{
	// Will be used for attenuation.
    //float distance = length(u_LightPos - v_Position);
	
	// Get a lighting direction vector from the light to the vertex.
    // vec3 lightVector = normalize(u_LightPos - v_Position);

	// Calculate the dot product of the light vector and vertex normal. If the normal and light vector are
	// pointing in the same direction then it will get max illumination.
    //float diffuse = max(1.0, 0.0);

	// Add attenuation. 
    //diffuse = diffuse * (1.0 / (1.0 + (0.10 * distance)));
    
    // Add ambient lighting
    // diffuse = diffuse + 0.3;

	// Multiply the color by the diffuse illumination level and texture value to get final output color.
    //gl_FragColor =  texture2D(u_Texture, v_TexCoordinate);
//}

precision mediump float;
varying vec2 v_TexCoordinate;
uniform sampler2D tex_y;
uniform sampler2D tex_u;
uniform sampler2D tex_v;
void main(){
    vec3 yuv;
    vec3 rgb;
    yuv.x = texture2D(tex_y, v_TexCoordinate).r;
    yuv.y = texture2D(tex_u, v_TexCoordinate).r ;
    yuv.z = texture2D(tex_v, v_TexCoordinate).r ;
    rgb.z = 1.164*(yuv.x - 16.0 / 255.0) + 2.018*(yuv.y - 128.0 / 255.0);
    rgb.y = 1.164*(yuv.x - 16.0 / 255.0) - 0.813*(yuv.z - 128.0 / 255.0) - 0.391*(yuv.y - 128.0 / 255.0);
    rgb.x = 1.164*(yuv.x - 16.0 / 255.0) + 1.596*(yuv.z - 128.0 / 255.0);
    gl_FragColor = vec4(rgb, 1);
}

