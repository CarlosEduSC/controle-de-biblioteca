package models;

public enum TipoUsuario {
	Administrador,
	Aluno;

	private static TipoUsuario[] list = TipoUsuario.values();

    public static TipoUsuario getStatus(int i) {
        return list[i];
    }
}
