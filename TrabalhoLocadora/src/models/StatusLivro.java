package models;

public enum StatusLivro {
	Disponivel,
	Emprestado,
	Indisponivel;

	private static StatusLivro[] list = StatusLivro.values();

    public static StatusLivro getStatus(int i) {
        return list[i];
    }
}
