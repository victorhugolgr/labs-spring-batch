package br.com.victorhugolgr.arquivomultiplosformatosjob.reader;

import br.com.victorhugolgr.arquivomultiplosformatosjob.dominio.Cliente;
import br.com.victorhugolgr.arquivomultiplosformatosjob.dominio.Transacao;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import java.util.Objects;

@RequiredArgsConstructor
public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

    private final ItemStreamReader<Object> delegate;
    private Object objAtual;

    @Override
    public Cliente read() throws Exception {
        if(Objects.isNull(objAtual))
            objAtual = delegate.read();

        Cliente cliente = (Cliente) objAtual;
        objAtual = null;

        if( Objects.nonNull(cliente)) {
            while (peek() instanceof Transacao)
                cliente.getTransacoes().add((Transacao) objAtual);
        }

        return cliente;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    private Object peek() throws Exception {
        objAtual = delegate.read();
        return objAtual;
    }
}
