precision lowp float;

varying vec2 v_texCoord;
uniform float v_alpha;
uniform sampler2D s_texture;

void main() {
	gl_FragColor = texture2D(s_texture, v_texCoord);
	float alpha = v_alpha;
	gl_FragColor.a = gl_FragColor.a * alpha;
	gl_FragColor.r = gl_FragColor.r * alpha;
	gl_FragColor.g = gl_FragColor.g * alpha;
	gl_FragColor.b = gl_FragColor.b * alpha;
}
