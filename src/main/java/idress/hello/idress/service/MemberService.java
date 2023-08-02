package idress.hello.idress.service;

import idress.hello.idress.domain.Member;
import idress.hello.idress.exception.DuplicateMemberException;
import idress.hello.idress.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findByMemberId(member.getMemberId());
        findMember.ifPresent(m -> {
            throw new DuplicateMemberException("이미 존재하는 회원입니다.");
        });
    }
}
