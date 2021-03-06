package br.sceweb.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC07ExcluirConvenio {
	static ConvenioDAO convenioDAO;
	static Convenio convenio;
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();
		empresaDAO = new EmpresaDAO();
		convenioDAO = new ConvenioDAO();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("81965361000174");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		convenio = new Convenio("81965361000174","03/05/2016", "20/05/2016");
		convenioDAO.adiciona(convenio);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("81965361000174");
	}

	@Test
	public void CT01UC07ExcluirConvenio_com_sucesso() {
		assertEquals(1,convenioDAO.exclui("81965361000174"));
	}

}
